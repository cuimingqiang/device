package org.example.service;

import org.example.model.user.User;

import java.util.Map;

public interface UserService {

    String login(Map<String,String> data);

    String register(Map<String, String> user);
}
