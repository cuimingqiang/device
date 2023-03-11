package org.example.service.imp;

import org.example.exception.HttpException;
import org.example.model.user.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.example.utils.JWTUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
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
            if (!StringUtils.hasText(user.deviceFingerprint)) {
                user.deviceFingerprint = deviceFingerprint;
                userRepository.save(user);
            } else if (!user.deviceFingerprint.equals(deviceFingerprint)) {
                throw new HttpException(403, "账号设备已绑定，请先解绑");
            }
            if (user.expiryDate == null || user.expiryDate.before(new Date())) {
                throw new HttpException(404, "账号已过期");
            }
            return JWTUtils.geneUserToken(user);
        }
        throw new HttpException(400, "用户不存在");
    }

    @Override
    public User register(String account, String password, Date expireDate) {
        User user = new User(account, password, new Date(), expireDate);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User findUser(String account) {
        return userRepository.findUserByAccount(account);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void unbind(String deviceAccount, String devicePassword) {
        userRepository.unbind(deviceAccount, devicePassword);
    }
}
