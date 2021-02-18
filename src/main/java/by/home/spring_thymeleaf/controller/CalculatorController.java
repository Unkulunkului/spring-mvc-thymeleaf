package by.home.spring_thymeleaf.controller;


import by.home.spring_thymeleaf.entity.CalcHistory;
import by.home.spring_thymeleaf.entity.Operation;
import by.home.spring_thymeleaf.service.CalculatorService;
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
@RequestMapping(path = "/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;
    @GetMapping
    public ModelAndView getCalculatorPage(ModelAndView modelAndView){
        modelAndView.setViewName("calculator");
        modelAndView.addObject("ModelAttributeOperation", new Operation());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView postCalculatorPage(@Valid @ModelAttribute("ModelAttributeOperation") Operation operation,
                                           BindingResult bindingResult, ModelAndView modelAndView, HttpSession httpSession){
        if (!bindingResult.hasErrors()) {
            if(!(operation.getOperation().equals("div") && operation.getsNum() == 0)){
                calculatorService.getResult(operation);
                CalcHistory calculatorHistory = (CalcHistory) httpSession.getAttribute("calculatorHistory");
                calculatorHistory.save(operation);
                if(!operation.getOperation().equals("Wrong operation")){
                    httpSession.setAttribute("calculatorHistory", calculatorHistory);
                    modelAndView.addObject("result", operation);
                }else{
                    modelAndView.addObject("result", "Wrong operation!");
                }
            }else{
                modelAndView.addObject("result", "Divided by zero!");
            }
        }
        modelAndView.setViewName("calculator");
        return modelAndView;
    }
}
