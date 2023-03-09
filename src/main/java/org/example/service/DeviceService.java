package org.example.service;

import org.example.model.device.DeviceNewParam;

import java.util.List;
import java.util.Map;

public interface DeviceService {

    void uploadDevice(Map<String, Object> deviceInfo);

    DeviceNewParam getDevice(Map<String, Object> deviceInfo, String account, String deviceFingerprint);

    List<DeviceNewParam> getAllDevice();

    void deleteDevice(long deviceId);
}
