package org.example.service;

import org.example.model.user.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserService {

    String login(Map<String,String> data);

    User register(String account, String password, Date expireDate);

    User findUser(String account);

    void save(User user);

    void unbind(String deviceAccount, String devicePassword);

    List<User> query(String account);

    void unbind(Long id);

    void deleteUser(Long id);
}
