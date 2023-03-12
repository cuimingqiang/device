package org.example.model.device;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Debug {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    public boolean debuggable;
    public boolean debugger;

    public boolean adb_enabled;

    public boolean shell;
    @SerializedName("ro.debuggable")
    public boolean rodebuggable;
    @SerializedName("ro.secure")
    public boolean rosecure;

   
}