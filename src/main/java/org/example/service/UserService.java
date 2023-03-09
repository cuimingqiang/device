package org.example.service;

import org.example.model.user.User;

import java.util.Map;

public interface UserService {

    User login(Map<String,String> data);
}
