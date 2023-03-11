package org.example.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity

public class User {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    @Column(unique = true)
    public String account;

    @JsonIgnore
    public String password;

    public String owner;

    public String deviceFingerprint;

    public Date createData;
    public Date expiryDate;

    public User() {
    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public User(String account, String password, Date createData, Date expiryDate) {
        this.account = account;
        this.password = password;
        this.createData = createData;
        this.expiryDate = expiryDate;
    }

    public User(Long id, String account, String password, String deviceFingerprint) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.deviceFingerprint = deviceFingerprint;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", deviceFingerprint='" + deviceFingerprint + '\'' +
                '}';
    }
}
