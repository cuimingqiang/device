package org.example.web;

import org.example.base.BaseResult;
import org.example.service.UserService;
import org.example.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("login")
    public Object login(@RequestBody Map<String,String> data){
        User user = userService.login(data);
        if (user == null)return BaseResult.error(401,"登录失败");
        return BaseResult.succees(user);
    }


}
