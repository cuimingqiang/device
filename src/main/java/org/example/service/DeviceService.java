package org.example.service;

import org.example.model.device.DeviceNewParam;
import org.example.model.device.view.DeviceView;
import org.example.model.request.DeviceRegisterParam;
import org.example.model.request.DeviceRenewParam;
import org.example.model.request.DeviceUnbindParam;

import java.util.List;
import java.util.Map;

public interface DeviceService {

    void uploadDevice(Map<String, Object> deviceInfo);

    DeviceNewParam getDevice(Map<String, Object> deviceInfo, String account, String deviceFingerprint);

    DeviceNewParam getDevice(long id);

    List<DeviceView> getAllDevice();

    void deleteDevice(long deviceId);

    Object renew(DeviceRenewParam param);

    Object register(DeviceRegisterParam param);

    void unbind(DeviceUnbindParam param);
}
