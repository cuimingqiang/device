package org.example.model.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserManager {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    @Column(unique = true)
    public String account;

    public String password;

    public String role;
}
