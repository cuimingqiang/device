package org.example.service;

import com.google.gson.Gson;
import org.example.model.device.DeviceNewParam;
import org.example.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class DeviceServiceImp implements DeviceService {
    @Autowired
    DeviceRepository deviceRepository;

    @Override
    public void uploadDevice(Map<String, Object> deviceInfo) {
        Gson gson = new Gson();
        String json = gson.toJson(deviceInfo);
        DeviceNewParam param = gson.fromJson(json, DeviceNewParam.class);
        deviceRepository.save(param);

    }

    @Override
    public DeviceNewParam getDevice(Map<String, Object> deviceInfo) {
        String country = null;
        try {
            country = deviceInfo.get("country").toString();//国家
        } catch (Exception ignored) {
        }

        Integer osVersion = null;//系统版本
        try {
            osVersion = Integer.parseInt(deviceInfo.get("osVersion").toString());
        } catch (Exception ignored) {
        }
        List<Long> byHql = deviceRepository.getDeviceIdByHql(country, osVersion);
        System.out.println("--查询到符合条件的--" + byHql);
        if (byHql == null || byHql.isEmpty()) {
            byHql = deviceRepository.getAllDeviceId();
        }
        if (byHql == null || byHql.isEmpty()) return null;
        int i = new Random().nextInt(byHql.size());
        return deviceRepository.findById(byHql.get(i)).get();
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
