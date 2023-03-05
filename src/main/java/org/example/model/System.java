package org.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class System {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    private String country;

    private List<String> xtbb;

    private int signaturehash;

    private int gpsAvailable;

    private int processcount;

    private String btype;

    private boolean headsetOn;

    private boolean headingAvailable;

    private boolean sof;

    private boolean makePhoneAvailable;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "gmsl")
    private Mcmt mcmt;

    private boolean efig;

    private List<String> processlist;

    private String systemUa;

    private String appname;

    private List<String> runningServices;

    private boolean backCamera;

    private boolean rearCameraAvailable;

    private boolean multiTouch;

    private boolean sl;

    private boolean frontCamera;

    private boolean frontCameraAvailable;

    private String bhost;

    private boolean fingerprintAvailable;

    private String lastupdatetime;

    private boolean af;

    private List<String> ipAddress;

    private String packagename;

    private String timeZone;

    private String countries;

    private boolean figst;

    private boolean nfcEnable;

    private boolean nfcst;

    private String ulan;

    private String slan;

    private int statusbarheight;

    private boolean rearCameraFlashAvailable;

    private int brightness;

    private String firstinstalltime;

    private String buser;

    private String webUa;

    private String bid;

    private String launcher;

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }

    public void setXtbb(List<String> xtbb) {
        this.xtbb = xtbb;
    }

    public List<String> getXtbb() {
        return this.xtbb;
    }

    public void setSignaturehash(int signaturehash) {
        this.signaturehash = signaturehash;
    }

    public int getSignaturehash() {
        return this.signaturehash;
    }

    public void setGpsAvailable(int gpsAvailable) {
        this.gpsAvailable = gpsAvailable;
    }

    public int getGpsAvailable() {
        return this.gpsAvailable;
    }

    public void setProcesscount(int processcount) {
        this.processcount = processcount;
    }

    public int getProcesscount() {
        return this.processcount;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    public String getBtype() {
        return this.btype;
    }

    public void setHeadsetOn(boolean headsetOn) {
        this.headsetOn = headsetOn;
    }

    public boolean getHeadsetOn() {
        return this.headsetOn;
    }

    public void setHeadingAvailable(boolean headingAvailable) {
        this.headingAvailable = headingAvailable;
    }

    public boolean getHeadingAvailable() {
        return this.headingAvailable;
    }

    public void setSof(boolean sof) {
        this.sof = sof;
    }

    public boolean getSof() {
        return this.sof;
    }

    public void setMakePhoneAvailable(boolean makePhoneAvailable) {
        this.makePhoneAvailable = makePhoneAvailable;
    }

    public boolean getMakePhoneAvailable() {
        return this.makePhoneAvailable;
    }

    public void setMcmt(Mcmt mcmt) {
        this.mcmt = mcmt;
    }

    public Mcmt getMcmt() {
        return this.mcmt;
    }

    public void setEfig(boolean efig) {
        this.efig = efig;
    }

    public boolean getEfig() {
        return this.efig;
    }

    public void setProcesslist(List<String> processlist) {
        this.processlist = processlist;
    }

    public List<String> getProcesslist() {
        return this.processlist;
    }

    public void setSystemUa(String systemUa) {
        this.systemUa = systemUa;
    }

    public String getSystemUa() {
        return this.systemUa;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getAppname() {
        return this.appname;
    }

    public void setRunningServices(List<String> runningServices) {
        this.runningServices = runningServices;
    }

    public List<String> getRunningServices() {
        return this.runningServices;
    }

    public void setBackCamera(boolean backCamera) {
        this.backCamera = backCamera;
    }

    public boolean getBackCamera() {
        return this.backCamera;
    }

    public void setRearCameraAvailable(boolean rearCameraAvailable) {
        this.rearCameraAvailable = rearCameraAvailable;
    }

    public boolean getRearCameraAvailable() {
        return this.rearCameraAvailable;
    }

    public void setMultiTouch(boolean multiTouch) {
        this.multiTouch = multiTouch;
    }

    public boolean getMultiTouch() {
        return this.multiTouch;
    }

    public void setSl(boolean sl) {
        this.sl = sl;
    }

    public boolean getSl() {
        return this.sl;
    }

    public void setFrontCamera(boolean frontCamera) {
        this.frontCamera = frontCamera;
    }

    public boolean getFrontCamera() {
        return this.frontCamera;
    }

    public void setFrontCameraAvailable(boolean frontCameraAvailable) {
        this.frontCameraAvailable = frontCameraAvailable;
    }

    public boolean getFrontCameraAvailable() {
        return this.frontCameraAvailable;
    }

    public void setBhost(String bhost) {
        this.bhost = bhost;
    }

    public String getBhost() {
        return this.bhost;
    }

    public void setFingerprintAvailable(boolean fingerprintAvailable) {
        this.fingerprintAvailable = fingerprintAvailable;
    }

    public boolean getFingerprintAvailable() {
        return this.fingerprintAvailable;
    }

    public void setLastupdatetime(String lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    public String getLastupdatetime() {
        return this.lastupdatetime;
    }

    public void setAf(boolean af) {
        this.af = af;
    }

    public boolean getAf() {
        return this.af;
    }

    public void setIpAddress(List<String> ipAddress) {
        this.ipAddress = ipAddress;
    }

    public List<String> getIpAddress() {
        return this.ipAddress;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public String getPackagename() {
        return this.packagename;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getCountries() {
        return this.countries;
    }

    public void setFigst(boolean figst) {
        this.figst = figst;
    }

    public boolean getFigst() {
        return this.figst;
    }

    public void setNfcEnable(boolean nfcEnable) {
        this.nfcEnable = nfcEnable;
    }

    public boolean getNfcEnable() {
        return this.nfcEnable;
    }

    public void setNfcst(boolean nfcst) {
        this.nfcst = nfcst;
    }

    public boolean getNfcst() {
        return this.nfcst;
    }

    public void setUlan(String ulan) {
        this.ulan = ulan;
    }

    public String getUlan() {
        return this.ulan;
    }

    public void setSlan(String slan) {
        this.slan = slan;
    }

    public String getSlan() {
        return this.slan;
    }

    public void setStatusbarheight(int statusbarheight) {
        this.statusbarheight = statusbarheight;
    }

    public int getStatusbarheight() {
        return this.statusbarheight;
    }

    public void setRearCameraFlashAvailable(boolean rearCameraFlashAvailable) {
        this.rearCameraFlashAvailable = rearCameraFlashAvailable;
    }

    public boolean getRearCameraFlashAvailable() {
        return this.rearCameraFlashAvailable;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public int getBrightness() {
        return this.brightness;
    }

    public void setFirstinstalltime(String firstinstalltime) {
        this.firstinstalltime = firstinstalltime;
    }

    public String getFirstinstalltime() {
        return this.firstinstalltime;
    }

    public void setBuser(String buser) {
        this.buser = buser;
    }

    public String getBuser() {
        return this.buser;
    }

    public void setWebUa(String webUa) {
        this.webUa = webUa;
    }

    public String getWebUa() {
        return this.webUa;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBid() {
        return this.bid;
    }

    public void setLauncher(String launcher) {
        this.launcher = launcher;
    }

    public String getLauncher() {
        return this.launcher;
    }
}