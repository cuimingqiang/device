package org.example.model.device;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DataRomInfo {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    public long blockCount;

    public long totalSize;

    public long blockSize;

    public long availCount;

}