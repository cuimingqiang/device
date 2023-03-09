package org.example.model.device;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Ram {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    public long total;

    public long available;


}