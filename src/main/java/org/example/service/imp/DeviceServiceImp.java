package org.example.service.imp;

import com.google.gson.Gson;
import org.example.exception.CustomExceptionHandler;
import org.example.exception.HttpException;
import org.example.model.device.DeviceNewParam;
import org.example.model.record.DeviceUseRecord;
import org.example.repository.DeviceRecordRepository;
import org.example.repository.DeviceRepository;
import org.example.service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
public class DeviceServiceImp implements DeviceService {
    private final static Logger logger = LoggerFactory.getLogger(DeviceServiceImp.class);
    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    DeviceRecordRepository recordRepository;

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
            logger.error("[getDevice os country]{}",e.getMessage());
        }

        String osVersion = null;//系统版本
        try {
            osVersion = deviceInfo.get("osVersion").toString();
        } catch (Exception e) {
            logger.error("[getDevice os version]{}",e.getMessage());
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
    public List<DeviceNewParam> getAllDevice() {

        return deviceRepository.findAll();
    }

    @Override
    public void deleteDevice(long deviceId) {
        deviceRepository.deleteById(deviceId);
    }
}
