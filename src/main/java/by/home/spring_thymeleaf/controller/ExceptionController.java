package by.home.spring_thymeleaf.controller;

import by.home.spring_thymeleaf.service.exception.UserIsAlreadyExist;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler
    public String getPage(Model model, UserIsAlreadyExist ex){
        model.addAttribute("message", ex.getMessage());
        return "error";
    }
}
