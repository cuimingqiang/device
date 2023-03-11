package org.example.model.request;

public class DeviceUnbindParam {
    public String deviceAccount;
    public String devicePassword;

    @Override
    public String toString() {
        return "DeviceUnbindParam{" +
                "deviceAccount='" + deviceAccount + '\'' +
                ", devicePassword='" + devicePassword + '\'' +
                '}';
    }
}
