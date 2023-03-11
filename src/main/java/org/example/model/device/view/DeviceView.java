package org.example.model.device.view;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "device_view")
public class DeviceView {
    @Id
    private long id;
    public String manufacture;
    public String model;
    public String osVersion;
    public String sdkVersion;
    public String country;
}
