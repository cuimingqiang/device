package org.example.model.device;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Identifier
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    private String WidevineID;

    private String GUID;

    private String OAID;

    private String IMEI;

    private String PseudoID;

    private String AndroidId;

    public void setWidevineID(String WidevineID){
        this.WidevineID = WidevineID;
    }
    public String getWidevineID(){
        return this.WidevineID;
    }
    public void setGUID(String GUID){
        this.GUID = GUID;
    }
    public String getGUID(){
        return this.GUID;
    }
    public void setOAID(String OAID){
        this.OAID = OAID;
    }
    public String getOAID(){
        return this.OAID;
    }
    public void setIMEI(String IMEI){
        this.IMEI = IMEI;
    }
    public String getIMEI(){
        return this.IMEI;
    }
    public void setPseudoID(String PseudoID){
        this.PseudoID = PseudoID;
    }
    public String getPseudoID(){
        return this.PseudoID;
    }
    public void setAndroidId(String AndroidId){
        this.AndroidId = AndroidId;
    }
    public String getAndroidId(){
        return this.AndroidId;
    }
}