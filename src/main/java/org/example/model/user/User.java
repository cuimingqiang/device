package org.example.model.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    @Column(unique = true)
    public String account;

    public String password;

    public String deviceFingerprint;

    public User() {
    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
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
