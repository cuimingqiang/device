package org.example.model.request;

public class DeviceRenewParam {
    public String cardNo;
    public String cardPassword;
    public String deviceAccount;

    @Override
    public String toString() {
        return "DeviceRenewParam{" +
                "cardNo='" + cardNo + '\'' +
                ", cardPassword='" + cardPassword + '\'' +
                ", deviceAccount='" + deviceAccount + '\'' +
                '}';
    }
}
