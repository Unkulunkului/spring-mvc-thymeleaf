package by.home.spring_thymeleaf.service;

import by.home.spring_thymeleaf.entity.Operation;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private double sum(double fNum, double sNum){
        return fNum+sNum;
    }

    private double div(double fNum, double sNum){
        return fNum/sNum;
    }

    private double mult(double fNum, double sNum){
        return fNum*sNum;
    }

    private double diff(double fNum, double sNum){
        return fNum-sNum;
    }

    public Operation getResult(Operation operation){
        switch (operation.getOperation()){
            case "div":
                operation.setResult(div(operation.getfNum(), operation.getsNum()));
                break;
            case "mult":
                operation.setResult(mult(operation.getfNum(), operation.getsNum()));
                break;
            case "diff":
                operation.setResult(diff(operation.getfNum(), operation.getsNum()));
                break;
            case "sum":
                operation.setResult(sum(operation.getfNum(), operation.getsNum()));
                break;
            default:
                operation.setOperation("Wrong operation");
                break;
        }
        return operation;
    }
}
