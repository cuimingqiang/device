package org.example.model.device;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Battery {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    public String technology;

    @SerializedName("icon-small")
    public int iconSmall;

    public int max_charging_voltage;

    public int health;

    public int max_charging_current;

    public int status;

    public int plugged;

    public boolean present;

    public int seq;

    public int charge_counter;

    public int level;

    public int scale;

    public int temperature;

    public int voltage;

    public int invalid_charger;

    public boolean battery_low;


}