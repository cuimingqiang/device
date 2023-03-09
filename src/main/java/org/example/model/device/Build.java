package org.example.model.device;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Build {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    public String radioversion;

    @SerializedName("fcgn-fingerprint")
    @Column(length = Integer.MAX_VALUE)
    public String fcgnfingerprint;

    public int androidSDKVersion;

    public String pt;
    @Column(length = Integer.MAX_VALUE)
    public String buildInfo;
    @Column(length = Integer.MAX_VALUE)
    public String realscreensize;

    public String display;

    public String ovsi;
    @Column(length = Integer.MAX_VALUE)
    public String linuxVersion;

    public String platform;

    public String manufacture;

    public String osversiontags;

    public String osVersion;

    public String bootloader;
    @Column(length = Integer.MAX_VALUE)
    public String fingerprint;

    public String romname;

    public String model;

    public String devicename;

    public String device;

    public String androidId;

    public String board;

    public String hardware;

    public String ispt;

}
