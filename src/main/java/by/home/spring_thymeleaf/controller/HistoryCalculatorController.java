package by.home.spring_thymeleaf.controller;

import by.home.spring_thymeleaf.entity.CalcHistory;
import by.home.spring_thymeleaf.entity.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(path = "/calc/history")
public class HistoryCalculatorController {
    @GetMapping
    public ModelAndView getHistoryPage(ModelAndView modelAndView, HttpSession httpSession){
        CalcHistory calculatorHistory = (CalcHistory) httpSession.getAttribute("calculatorHistory");
        List<Operation> operationList = calculatorHistory.getOperationList();
        modelAndView.addObject("calculatorHistory", operationList);
        modelAndView.setViewName("calculatorHistory");
        return modelAndView;
    }
}

