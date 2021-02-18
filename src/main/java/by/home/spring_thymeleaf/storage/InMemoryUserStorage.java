package by.home.spring_thymeleaf.storage;


import by.home.spring_thymeleaf.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryUserStorage {
    private List<User> userList = new ArrayList<>();
    private static int gen = 0;

    {
        userList.add(new User(gen++, "Admin", "Admin", "admin"));
    }

    public List<User> getUserList(){
        return new ArrayList<>(userList);
    }

    public boolean add(User user){
        if(!userList.contains(user)){
            user.setId(gen++);
            userList.add(user);
            return true;
        }
        return false;
    }

    public User userGetByLogin(String login){
        for (User user : userList) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
}
