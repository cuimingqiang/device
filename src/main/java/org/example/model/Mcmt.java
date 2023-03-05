package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Mcmt {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    private String minicap;

    private String minitouch;

    public void setMinicap(String minicap) {
        this.minicap = minicap;
    }

    public String getMinicap() {
        return this.minicap;
    }

    public void setMinitouch(String minitouch) {
        this.minitouch = minitouch;
    }

    public String getMinitouch() {
        return this.minitouch;
    }
}