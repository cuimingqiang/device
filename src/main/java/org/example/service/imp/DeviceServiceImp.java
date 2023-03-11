package org.example.service.imp;

import com.google.gson.Gson;
import org.example.exception.HttpException;
import org.example.model.card.Card;
import org.example.model.device.DeviceNewParam;
import org.example.model.device.view.DeviceView;
import org.example.model.record.DeviceUseRecord;
import org.example.model.request.DeviceRegisterParam;
import org.example.model.request.DeviceRenewParam;
import org.example.model.request.DeviceUnbindParam;
import org.example.model.user.User;
import org.example.repository.DeviceRecordRepository;
import org.example.repository.DeviceRepository;
import org.example.repository.DeviceViewRepository;
import org.example.service.ChargeService;
import org.example.service.DeviceService;
import org.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class DeviceServiceImp implements DeviceService {
    private final static Logger logger = LoggerFactory.getLogger(DeviceServiceImp.class);
    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    DeviceViewRepository deviceViewRepository;
    @Autowired
    DeviceRecordRepository recordRepository;

    @Autowired
    UserService userService;

    @Autowired
    ChargeService chargeService;

    @Override
    public void uploadDevice(Map<String, Object> deviceInfo) {
        Gson gson = new Gson();
        String json = gson.toJson(deviceInfo);
        DeviceNewParam param = gson.fromJson(json, DeviceNewParam.class);
        deviceRepository.save(param);

    }

    @Override
    public DeviceNewParam getDevice(Map<String, Object> deviceInfo, String account, String deviceFingerprint) {
        String country = null;
        try {
            country = deviceInfo.get("country").toString();//国家
        } catch (Exception e) {
            logger.error("[getDevice os country]{}", e.getMessage());
        }

        String osVersion = null;//系统版本
        try {
            osVersion = deviceInfo.get("osVersion").toString();
        } catch (Exception e) {
            logger.error("[getDevice os version]{}", e.getMessage());
        }
        List<Long> byHql = deviceRepository.getDeviceByOsVersion(osVersion);
        System.out.println("--查询到符合条件的--" + byHql);
        if (byHql == null || byHql.isEmpty()) {
            byHql = deviceRepository.getAllDeviceId();
        }
        if (byHql == null || byHql.isEmpty()) return null;
        int i = new Random().nextInt(byHql.size());
        Optional<DeviceNewParam> device = deviceRepository.findById(byHql.get(i));
        if (device.isPresent()) {
            DeviceNewParam param = device.get();
            DeviceUseRecord record = new DeviceUseRecord(
                    param.id,
                    param.build.model,
                    param.build.osVersion,
                    param.system.getCountry(),
                    account, deviceFingerprint

            );
            //插入一条下发记录
            recordRepository.save(record);
            return param;
        }
        throw new HttpException(500, "机型随机识别");
    }

    @Override
    public DeviceNewParam getDevice(long id) {
        Optional<DeviceNewParam> param = deviceRepository.findById(id);
        return param.orElse(null);
    }

    @Override
    public List<DeviceView> getAllDevice() {
        return deviceViewRepository.findAll();
    }

    @Override
    public void deleteDevice(long deviceId) {
        deviceRepository.deleteById(deviceId);
    }

    @Override
    public Object renew(DeviceRenewParam param) {
        if (!StringUtils.hasLength(param.deviceAccount)) throw new HttpException(400, "账号不能为空");
        if (!StringUtils.hasLength(param.cardNo)) throw new HttpException(400, "卡密不能味空");
        if (!StringUtils.hasLength(param.cardPassword)) throw new HttpException(400, "校验码不能为空");

        Card card = chargeService.getCard(param.cardNo, param.cardPassword);
        if (card == null) throw new HttpException(401, "卡密不存在或校验码不正确");
        Date expireDate = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(expireDate);
        if (card.type == 0) {
            instance.add(Calendar.YEAR, card.validity);
        } else if (card.type == 1) {
            instance.add(Calendar.MONTH, card.validity);
        } else if (card.type == 2) {
            instance.add(Calendar.WEEK_OF_MONTH, card.validity);
        } else if (card.type == 3) {
            instance.add(Calendar.DAY_OF_MONTH, card.validity);
        }
        logger.info("[renew]{}--{}--{}", param, card, instance.getTime());

        User user = userService.findUser(param.deviceAccount);
        if (user == null) throw new HttpException(400, "账号不存在");
        card.userId = user.id;
        card.isUsed = 1;
        chargeService.active(card);

        user.expiryDate = instance.getTime();
        userService.save(user);
        return null;
    }

    @Override
    public Object register(DeviceRegisterParam param) {
        if (!StringUtils.hasLength(param.deviceAccount)) throw new HttpException(400, "账号不能为空");
        if (!StringUtils.hasLength(param.devicePassword)) throw new HttpException(400, "密码不能为空");
        if (!StringUtils.hasLength(param.cardNo)) throw new HttpException(400, "卡密不能味空");
        if (!StringUtils.hasLength(param.cardPassword)) throw new HttpException(400, "校验码不能为空");
        logger.info("[register]{}",param);
        Card card = chargeService.getCard(param.cardNo, param.cardPassword);
        if (card == null) throw new HttpException(401, "卡密不存在或校验码不正确");
        Date expireDate = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(expireDate);
        if (card.type == 0) {
            instance.add(Calendar.YEAR, card.validity);
        } else if (card.type == 1) {
            instance.add(Calendar.MONTH, card.validity);
        } else if (card.type == 2) {
            instance.add(Calendar.WEEK_OF_MONTH, card.validity);
        } else if (card.type == 3) {
            instance.add(Calendar.DAY_OF_MONTH, card.validity);
        }
        logger.info("[register]{}--{}--{}", param, card, instance.getTime());
        try {
            User register = userService.register(param.deviceAccount, param.devicePassword, instance.getTime());
            card.userId = register.id;
            card.isUsed = 1;
            chargeService.active(card);
        } catch (Exception e) {
            logger.error("[register] {}", e.getMessage());
        }
        return "激活成功";
    }

    @Override
    public void unbind(DeviceUnbindParam param) {

        userService.unbind(param.deviceAccount,param.devicePassword);
    }
}
