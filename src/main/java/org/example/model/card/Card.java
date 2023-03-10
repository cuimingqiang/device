package org.example.model.card;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Card {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    public Long id;

    public String cardNo;
    public String cardPassword;

    public Date createDate;
    //有效期
    public int validity;
    //类型，年卡，月卡，周卡，日卡
    public int type;
    //是否已使用
    public int isUsed;
    //绑定的设备
    public String deviceId;
}
