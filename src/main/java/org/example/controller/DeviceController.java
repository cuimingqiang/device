package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.base.BaseResult;
import org.example.model.device.DeviceNewParam;
import org.example.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/api/v1/device")
@RestController
public class DeviceController {
    @Autowired
    DeviceService deviceService;

    @PostMapping("/upload")
    public Object upload(@RequestBody Map<String, Object> deviceInfo) {
        deviceService.uploadDevice(deviceInfo);
        return BaseResult.success("上传成功");
    }

    @PostMapping("/random")
    public Object getDevice(@RequestBody Map<String, Object> filter, HttpServletRequest request) {
        String account = (String) request.getAttribute("account");
        String deviceFingerprint = (String) request.getAttribute("deviceFingerprint");
        DeviceNewParam device = deviceService.getDevice(filter,account,deviceFingerprint);
        return BaseResult.success(device);
    }

}
