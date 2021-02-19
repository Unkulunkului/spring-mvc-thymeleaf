package by.home.spring_thymeleaf.entity;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Operation {

    private double fNum;
    private double sNum;
    @NotBlank
    private String operation;
    private double result;

    public Operation() {
    }

    public Operation(double fNum, double sNum, String operation) {
        this.fNum = fNum;
        this.sNum = sNum;
        this.operation = operation;
    }

    public double getfNum() {
        return fNum;
    }

    public void setfNum(double fNum) {
        this.fNum = fNum;
    }

    public double getsNum() {
        return sNum;
    }

    public void setsNum(double sNum) {
        this.sNum = sNum;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return fNum+" + "+sNum+" = "+result;
    }
}
