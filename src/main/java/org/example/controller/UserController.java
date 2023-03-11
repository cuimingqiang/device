package org.example.controller;

import org.example.base.BaseResult;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Object login(@RequestBody Map<String,String> data){
        String token = userService.login(data);
        if (token == null)return BaseResult.error(400,"用户不存在");
        return BaseResult.success(token);
    }

}
