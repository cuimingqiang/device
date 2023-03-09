package org.example.model.record;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class RechargeRecord {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;
    //0,单个账号，1整组账号
    public int type;

    public long userOrGroupId;
    public long time;
}
