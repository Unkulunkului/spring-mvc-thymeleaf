package by.home.spring_thymeleaf.controller;

import by.home.spring_thymeleaf.entity.User;
import by.home.spring_thymeleaf.entity.UserModel;
import by.home.spring_thymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/authorization")
    public ModelAndView getAuthorizationPage(ModelAndView modelAndView){
        modelAndView.addObject("ModelAttribute", new UserModel());
        modelAndView.setViewName("authorization");
        return modelAndView;
    }

    @PostMapping(path = "/authorization")
    public ModelAndView postAuthorizationPage(@Valid @ModelAttribute("ModelAttribute")UserModel userModel,
                                              BindingResult bindingResult, ModelAndView modelAndView, HttpSession httpSession){
        if(!bindingResult.hasErrors()){
            User user = new User();
            user.setLogin(userModel.getLogin());
            user.setPassword(userModel.getPassword());
            User byLogin = userService.getByLogin(user.getLogin());
            if (byLogin != null && userService.isRightPassword(byLogin, user.getPassword())) {
                httpSession.setAttribute("user", byLogin);
                httpSession.setAttribute("isUser", true);
                httpSession.setAttribute("isGuest", false);
                if (byLogin.getLogin().equals("Admin")) {
                    httpSession.setAttribute("isAdmin", true);
                }
                modelAndView.setViewName("redirect:/");
            }else{
                modelAndView.addObject("incorrectInput", "Incorrect login or password");
                modelAndView.setViewName("authorization");
            }
        }else{
            modelAndView.setViewName("authorization");
        }
        return modelAndView;
    }

    @GetMapping("/registration")
    public ModelAndView getRegistrationPage(ModelAndView modelAndView){
        modelAndView.addObject("ModelAttribute", new User());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(path = "/registration")
    public ModelAndView postRegistrationPage(@Valid @ModelAttribute("ModelAttribute")User user,
                                              BindingResult bindingResult, ModelAndView modelAndView, HttpSession httpSession){
        if(!bindingResult.hasErrors()){
            userService.save(user);
            modelAndView.setViewName("redirect:authorization");
        }else{
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }

    @GetMapping(path = "/logout")
    public String getLogOutPage(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/";
    }
}
