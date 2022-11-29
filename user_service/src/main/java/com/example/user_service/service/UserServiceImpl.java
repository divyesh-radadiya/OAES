package com.example.user_service.service;

import com.example.user_service.entity.User;
import com.example.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(Map<String,String> payload){
        String userName = payload.get("userName");
        String password = payload.get("password");

        boolean login = false;
        User admin = userRepository.findByUserName(userName);

        if(admin!=null && admin.getUserPassword().equals(password))
        {
            login = true;
        }
        else
        {
            login = false;
        }
        return login;
    }

}
