package org.example.model.device;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class SystemRomInfo {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    public Long blockCount;

    public Long totalSize;

    public Long blockSize;

    public Long availCount;


}