package org.example.model.record;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DeviceUseRecord {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;

    public long deviceId;

    public String model;
    public String osVersion;

    public String country;

    public long time = System.currentTimeMillis();

    public String deviceUser;

    public String deviceFingerprint;

    public DeviceUseRecord(long deviceId, String model, String osVersion, String country, String deviceUser, String deviceFingerprint) {
        this.deviceId = deviceId;
        this.model = model;
        this.osVersion = osVersion;
        this.country = country;
        this.deviceUser = deviceUser;
        this.deviceFingerprint = deviceFingerprint;
    }
}
