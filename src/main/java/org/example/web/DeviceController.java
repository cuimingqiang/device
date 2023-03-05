package org.example.web;

import org.example.base.BaseResult;
import org.example.model.DeviceNewParam;
import org.example.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/device")
@RestController
public class DeviceController {
    @Autowired
    DeviceService deviceService;

    @PostMapping("/upload")
    public Object upload(@RequestBody Map<String, Object> deviceInfo) {
        deviceService.uploadDevice(deviceInfo);
        return BaseResult.succees("上传成功");
    }

    @PostMapping("/getDevice")
    public Object getDevice(Map<String, Object> filter) {
        DeviceNewParam device = deviceService.getDevice(filter);
        return BaseResult.succees(device);
    }

    @GetMapping("/allDevice")
    public Object getAllDevice(String token) {
        if (!"1314926".equals(token)) return BaseResult.error(400, "未授权");
        return BaseResult.succees(deviceService.getAllDevice());
    }
}
