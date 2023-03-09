package org.example.model.device;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Network {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    public boolean isOnThePhone;

    public int rssi;

    public String routerIp;

    public String mnc;

    public String mobileCountryCode;
    @Column(length = Integer.MAX_VALUE)
    public List<String> wifissidlist;

    public String bssid;

    public String isoCountryCode;

    public String macId;

    @Column(length = Integer.MAX_VALUE)
    public List<String> wifiList;

    public String proxyInfo;
    @Column(length = Integer.MAX_VALUE)
    public List<String> dns;

    public int wifirssi;

    public int linkSpeed;

    public String mcc;

    public String ssid;

    public boolean wifiEnable;

    public boolean vpnConnect;

    public String network;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "gmsl")
    public Gmsl gmsl;

    public int wifilinkspeed;

    public String carrierName;

    public String netmask;
    
}