package org.example.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    public String account;

    public String password;

    public String token;
}
