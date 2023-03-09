package org.example.model.device;


import jakarta.persistence.*;
import org.example.MapToJsonConverter;

import java.util.List;
import java.util.Map;

@Entity
public class DeviceNewParam {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "identifier")
    public Identifier identifier;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "debug")
    public Debug debug;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cpu")
    public Cpu cpu;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "screen")
    public Screen screen;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "battery")
    public Battery battery;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "systemRomInfo")
    public SystemRomInfo systemRomInfo;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "network")
    public Network network;

    @Convert(converter = MapToJsonConverter.class)
    @Column(name = "props", length = Integer.MAX_VALUE)
    public Map<String, Object> props;

    @JoinColumn(name = "Lock_awake_receiver")
    public List<String> Lock_awake_receiver;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "system")
    public System system;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sensor_val")
    public List<SensorVal> sensor_val;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "build")
    public Build build;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sensor")
    public List<Sensor> sensor;

    public int sensorInfo;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sim")
    public Sim sim;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "appList")
    public List<AppList> appList;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "audio")
    public Audio audio;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sdcardRomInfo")
    public SdcardRomInfo sdcardRomInfo;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "dataRomInfo")
    public DataRomInfo dataRomInfo;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ram")
    public Ram ram;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "currentApp")
    public CurrentApp currentApp;

}
