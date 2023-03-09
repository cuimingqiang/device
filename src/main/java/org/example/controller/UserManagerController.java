package org.example.controller;

import org.example.base.BaseResult;
import org.example.exception.HttpException;
import org.example.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/api/v1/manager/user")
@RestController
public class UserManagerController {

    @Autowired
    UserManagerService managerService;

    @PostMapping("/login")
    public Object login(@RequestBody Map<String,String> param){
        String account = param.get("account");
        String password = param.get("password");
        String token = managerService.login(account, password);
        if (StringUtils.hasText(token))return BaseResult.success(token);
        throw new HttpException(400,"账号不存在");
    }
}
