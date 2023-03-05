package org.example.service;

import org.example.repository.UserRepository;
import org.example.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User login(Map<String, String> data) {
        String account = data.get("account");
        String password = data.get("password");
        if (StringUtils.hasLength(account) && StringUtils.hasLength(password)) {
            User user = userRepository.findUserByAccountAndPassword(account, password);
            if (user != null) {
                user.token = UUID.randomUUID().toString();
                userRepository.saveAndFlush(user);
            }
            return user;
        }
        return null;
    }
}
