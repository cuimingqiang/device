package org.example.model.device;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Audio {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    private int maxSystem;

    private int maxAlarm;

    private int maxMusic;

    private int maxRing;

    private int maxVoice;

    public void setMaxSystem(int maxSystem) {
        this.maxSystem = maxSystem;
    }

    public int getMaxSystem() {
        return this.maxSystem;
    }

    public void setMaxAlarm(int maxAlarm) {
        this.maxAlarm = maxAlarm;
    }

    public int getMaxAlarm() {
        return this.maxAlarm;
    }

    public void setMaxMusic(int maxMusic) {
        this.maxMusic = maxMusic;
    }

    public int getMaxMusic() {
        return this.maxMusic;
    }

    public void setMaxRing(int maxRing) {
        this.maxRing = maxRing;
    }

    public int getMaxRing() {
        return this.maxRing;
    }

    public void setMaxVoice(int maxVoice) {
        this.maxVoice = maxVoice;
    }

    public int getMaxVoice() {
        return this.maxVoice;
    }
}