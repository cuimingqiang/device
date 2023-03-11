package org.example.model.card;

import jakarta.persistence.Column;
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

    @Column(unique = true)
    public String cardNo;
    public String cardPassword;

    public Date createDate;
    //有效期
    public int validity;
    //类型，0年卡，1月卡，2周卡，3日卡
    public int type;
    //是否已使用
    public int isUsed;
    //绑定的设备
    public Long userId;

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNo='" + cardNo + '\'' +
                ", cardPassword='" + cardPassword + '\'' +
                ", createDate=" + createDate +
                ", validity=" + validity +
                ", type=" + type +
                ", isUsed=" + isUsed +
                ", userId=" + userId +
                '}';
    }
}
