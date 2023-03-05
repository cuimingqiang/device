package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class SdcardRomInfo {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    public long blockCount;

    public long totalSize;

    public boolean hasSdcard;

    public String sdCardId;

    public long blockSize;

    public String sdCid;

    public long availCount;


}