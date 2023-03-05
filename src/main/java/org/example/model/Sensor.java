package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Sensor {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long sensorId;

    public Long id;
    public String vendor;
    public String stringType;
    public String name;
    public int type;
    public int version;
    public double resolution;
}
