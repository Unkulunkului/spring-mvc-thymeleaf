package by.home.spring_thymeleaf.controller;


import by.home.spring_thymeleaf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/")
public class IndexController {

    @GetMapping
    public ModelAndView getPage(ModelAndView modelAndView, HttpSession httpSession){
        modelAndView.setViewName("index");
        User user = (User)httpSession.getAttribute("user");
        if (user != null) {
            modelAndView.addObject("name", user.getName());
        }
        return modelAndView;
    }
}
