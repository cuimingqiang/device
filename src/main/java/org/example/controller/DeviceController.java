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
        deviceService.deleteDevice(param.deviceId);
        return BaseResult.success("删除成功");
    }

    @GetMapping("/all")
    public Object getAllDevice() {
        return BaseResult.success(deviceService.getAllDevice());
    }
}
