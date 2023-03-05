package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Sim
{    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    private String simNetworkOperator;

    private int simNetworkType;

    private String simNetworkCountryIso;

    private String simCountryIso;

    private String simState;

    private String simOperator;

    private String simNetworkOperatorName;

    private String simOperatorName;

    public void setSimNetworkOperator(String simNetworkOperator){
        this.simNetworkOperator = simNetworkOperator;
    }
    public String getSimNetworkOperator(){
        return this.simNetworkOperator;
    }
    public void setSimNetworkType(int simNetworkType){
        this.simNetworkType = simNetworkType;
    }
    public int getSimNetworkType(){
        return this.simNetworkType;
    }
    public void setSimNetworkCountryIso(String simNetworkCountryIso){
        this.simNetworkCountryIso = simNetworkCountryIso;
    }
    public String getSimNetworkCountryIso(){
        return this.simNetworkCountryIso;
    }
    public void setSimCountryIso(String simCountryIso){
        this.simCountryIso = simCountryIso;
    }
    public String getSimCountryIso(){
        return this.simCountryIso;
    }
    public void setSimState(String simState){
        this.simState = simState;
    }
    public String getSimState(){
        return this.simState;
    }
    public void setSimOperator(String simOperator){
        this.simOperator = simOperator;
    }
    public String getSimOperator(){
        return this.simOperator;
    }
    public void setSimNetworkOperatorName(String simNetworkOperatorName){
        this.simNetworkOperatorName = simNetworkOperatorName;
    }
    public String getSimNetworkOperatorName(){
        return this.simNetworkOperatorName;
    }
    public void setSimOperatorName(String simOperatorName){
        this.simOperatorName = simOperatorName;
    }
    public String getSimOperatorName(){
        return this.simOperatorName;
    }
}