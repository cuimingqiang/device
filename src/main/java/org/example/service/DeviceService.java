package org.example.service;

import org.example.model.DeviceNewParam;

import java.util.List;
import java.util.Map;

public interface DeviceService {

    void uploadDevice(Map<String, Object> deviceInfo);

    DeviceNewParam getDevice(Map<String, Object> deviceInfo);

    List<DeviceNewParam> getAllDevice();
}
