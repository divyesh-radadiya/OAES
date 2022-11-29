package com.example.user_service.service;


import com.example.user_service.entity.User;

import java.util.Map;

public interface UserService {
    public boolean login(Map<String,String> payload);
}

