package org.example.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.base.BaseResult;
import org.example.model.device.DeviceNewParam;
import org.example.model.request.DeleteDeviceParam;
import org.example.service.DeviceService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api/v1/manager/device")
@RestController
public class DeviceManagerController {
    @Autowired
    DeviceService deviceService;

    @Autowired
    UserService userService;

    @PostMapping("/delete")
    public Object delete(@RequestBody DeleteDeviceParam param) {
        deviceService.deleteDevice(param.deviceId);
        return BaseResult.success("删除成功");
    }

    @GetMapping("/all")
    public Object getAllDevice() {
        return BaseResult.success(deviceService.getAllDevice());
    }

    @GetMapping("/device")
    public Object getDevice(@RequestParam("id") long id) {
        DeviceNewParam device = deviceService.getDevice(id);
        if (device == null) return null;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(device);
        return BaseResult.success(json);
    }

    @GetMapping("/users")
    public Object deviceUsers(@RequestParam("account") String account) {
        return BaseResult.success(userService.query(account));
    }
}
