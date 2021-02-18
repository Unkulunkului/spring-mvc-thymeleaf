package by.home.spring_thymeleaf.service;


import by.home.spring_thymeleaf.entity.User;
import by.home.spring_thymeleaf.service.exception.UserIsAlreadyExist;
import by.home.spring_thymeleaf.storage.InMemoryUserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private InMemoryUserStorage inMemoryUserStorage;

    public boolean save(User user){
        if (inMemoryUserStorage.add(user)) {
            return true;
        }
        throw new UserIsAlreadyExist("User is already exist :(");
    }

    public User getByLogin(String login){
        return inMemoryUserStorage.userGetByLogin(login);
    }

    public boolean isRightPassword(User user, String password){
        return user.getPassword().equals(password);
    }

    public List<User> getUserList(){
        return inMemoryUserStorage.getUserList();
    }
}
