package org.example.controller;

import org.example.base.BaseResult;
import org.example.model.device.DeviceNewParam;
import org.example.model.request.DeleteDeviceParam;
import org.example.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Object getDevice(Map<String, Object> filter) {
        DeviceNewParam device = deviceService.getDevice(filter);
        return BaseResult.success(device);
    }

    @PostMapping("/delete")
    public Object delete(@RequestBody DeleteDeviceParam param) {
        if (param == null || !"1314926".equals(param.token)) return BaseResult.error(400, "未授权");
        deviceService.deleteDevice(param.deviceId);
        return BaseResult.success(null);
    }

    @GetMapping("/allDevice")
    public Object getAllDevice(String token) {
        if (!"1314926".equals(token)) return BaseResult.error(400, "未授权");
        return BaseResult.success(deviceService.getAllDevice());
    }
}
