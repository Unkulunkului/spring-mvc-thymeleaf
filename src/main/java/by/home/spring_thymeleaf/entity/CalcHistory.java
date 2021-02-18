package by.home.spring_thymeleaf.entity;

import java.util.ArrayList;
import java.util.List;

public class CalcHistory {
    private List<Operation> operationList = new ArrayList<>();

    public void save(Operation operation){
        operationList.add(operation);
    }

    public List<Operation> getOperationList(){
        return new ArrayList<>(operationList);
    }
}
