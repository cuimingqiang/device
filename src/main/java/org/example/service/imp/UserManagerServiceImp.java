package org.example.service.imp;

import org.example.exception.HttpException;
import org.example.model.user.UserManager;
import org.example.repository.UserManagerRepository;
import org.example.service.UserManagerService;
import org.example.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserManagerServiceImp implements UserManagerService {
    @Autowired
    UserManagerRepository managerRepository;

    @Override
    public String login(String account, String password) {
        if (!StringUtils.hasLength(account)) throw new HttpException(400, "账号未空");
        if (!StringUtils.hasLength(password)) throw new HttpException(400, "密码未空");

        UserManager user = managerRepository.findUserByAccountAndPassword(account, password);
        if (user != null)
            return JWTUtils.geneUserManagerToken(user);
        throw new HttpException(400, "账号密码错误");
    }
}
