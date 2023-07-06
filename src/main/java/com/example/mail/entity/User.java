package com.example.mail.entity;

import lombok.Data;
import lombok.Getter;
import org.omg.PortableInterceptor.INACTIVE;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /**用户对应的id*/
    @Column(name = "id")
    private Integer userId;

    /**用户名*/
    @Column(name = "user_name")
    private String username;

    /**手机号*/
    @Column(name = "phone")
    private String phone;

    /**密码*/
    @Column(name = "password")
    private String password;

    /**账户余额*/
    @Column(name = "account_balance")
    private Double accountBalance;

    /**vip等级*/
    @Column(name = "vip_level")
    private Integer vipLevel;

    /**收货地址*/
    @Column(name = "shipping_address")
    private String shippingAddress;

    /**收藏的店铺*/
    @Column(name = "book_mark_stores")
    private String bookMarkStores;

    /**账户积分*/
    @Column(name = "account_score")
    private long accountScore;

    /**用户的电子邮箱*/
    @Column(name = "email")
    private String email;

    @Column(name = "true_name")
    private String trueName;

    public User(String phone,String password,String email,String username,String trueName){
        this.email=email;
        this.username=username;
        this.password=password;
        this.phone=phone;
        this.trueName=trueName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public Integer getVipLevel() {
        return vipLevel;
    }


    public long getAccountScore() {
        return accountScore;
    }

    public String getEmail() {
        return email;
    }

    public String getTrueName() {
        return trueName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", accountBalance=" + accountBalance +
                ", vipLevel=" + vipLevel +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", bookMarkStores='" + bookMarkStores + '\'' +
                ", accountScore=" + accountScore +
                ", email='" + email + '\'' +
                ", trueName='" + trueName + '\'' +
                '}';
    }
}
