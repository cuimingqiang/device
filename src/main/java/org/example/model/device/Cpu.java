package org.example.model.device;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;
@Entity
public class Cpu
{    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    private String cpuid;

    private String name;

    private String scalingMin;

    private String cpuMin;

    private String physicalcpu;
    @Column(length = Integer.MAX_VALUE)
    private List<String> scalingCur;

    private String cpuMax;

    @Column(length = Integer.MAX_VALUE)
    private List<String> cpuInfo;

    private String hardware;

    public void setCpuid(String cpuid){
        this.cpuid = cpuid;
    }
    public String getCpuid(){
        return this.cpuid;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setScalingMin(String scalingMin){
        this.scalingMin = scalingMin;
    }
    public String getScalingMin(){
        return this.scalingMin;
    }
    public void setCpuMin(String cpuMin){
        this.cpuMin = cpuMin;
    }
    public String getCpuMin(){
        return this.cpuMin;
    }
    public void setPhysicalcpu(String physicalcpu){
        this.physicalcpu = physicalcpu;
    }
    public String getPhysicalcpu(){
        return this.physicalcpu;
    }
    public void setScalingCur(List<String> scalingCur){
        this.scalingCur = scalingCur;
    }
    public List<String> getScalingCur(){
        return this.scalingCur;
    }
    public void setCpuMax(String cpuMax){
        this.cpuMax = cpuMax;
    }
    public String getCpuMax(){
        return this.cpuMax;
    }
    public void setCpuInfo(List<String> cpuInfo){
        this.cpuInfo = cpuInfo;
    }
    public List<String> getCpuInfo(){
        return this.cpuInfo;
    }
    public void setHardware(String hardware){
        this.hardware = hardware;
    }
    public String getHardware(){
        return this.hardware;
    }
}