package org.example.model.request;

public class DeviceRegisterParam {
    public String cardNo;
    public String cardPassword;
    public String deviceAccount;
    public String devicePassword;

    @Override
    public String toString() {
        return "DeviceRegisterParam{" +
                "cardNo='" + cardNo + '\'' +
                ", cardPassword='" + cardPassword + '\'' +
                ", deviceAccount='" + deviceAccount + '\'' +
                ", devicePassword='" + devicePassword + '\'' +
                '}';
    }
}
