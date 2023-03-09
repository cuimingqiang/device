package org.example.service;

import org.example.exception.HttpException;
import org.example.model.user.User;
import org.example.repository.UserRepository;
import org.example.utils.JWTUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

@Service
public class UserServiceImp implements UserService {
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImp.class);
    @Autowired
    UserRepository userRepository;

    @Override
    public String login(Map<String, String> data) {
        String account = data.get("account");
        String password = data.get("password");
        String deviceFingerprint = data.get("deviceFingerprint");
        logger.error("[ 用户登录 ]{},{}", account, deviceFingerprint);
        if (!StringUtils.hasLength(account)) throw new HttpException(400, "账号未空");
        if (!StringUtils.hasLength(password)) throw new HttpException(400, "密码未空");
        if (!StringUtils.hasLength(deviceFingerprint)) throw new HttpException(400, "未传入设备指纹");
        User user = userRepository.findUserByAccountAndPassword(account, password);
        logger.error("[ 用户登录 ]{}", user);
        if (user != null) {
            if (StringUtils.hasText(user.deviceFingerprint) && !user.deviceFingerprint.equals(deviceFingerprint)) {
                throw new HttpException(403, "账号设备已绑定，请先解绑");
            }
            logger.info("-------------");
            return JWTUtils.geneJsonWebToken(user);
        }
        throw new HttpException(400, "用户不存在");
    }

    @Override
    public String register(Map<String, String> user) {
        String account = user.get("account");
        String password = user.get("password");
        if (StringUtils.hasLength(account) && StringUtils.hasLength(password)) {
            try {
                userRepository.saveAndFlush(new User(account, password));
                return "创建成功";
            } catch (Exception e) {
                logger.error("[ 注册用户 ]{}", e.getMessage());
                throw new HttpException(402, "账号已存在");
            }

        }
        throw new HttpException(401, "账号密码不正确");
    }
}
