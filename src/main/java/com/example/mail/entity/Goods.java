package com.example.mail.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Table(name = "goods")
public class Goods implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "goods_id")
    private String goodsId;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "goods_description")
    private String goodsDescription;

    @Column(name = "vendors_id")
    private String vendorsId;

    @Column(name = "goods_price")
    private double goodsPrice;

    @Column(name = "production_date")
    private String productionDate;

    @Column(name = "discount")
    private boolean discount;

    @Column(name = "details")
    private String details;

    @Column(name = "picture_url")
    private String pictureUrl;

    public Goods(String goodsName, double goodsPrice,  String pictureUrl,String details) {
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.details = details;
        this.pictureUrl = pictureUrl;
    }

    public Goods(String goodsName, String goodsDescription, double goodsPrice, String pictureUrl) {
        this.goodsName = goodsName;
        this.goodsDescription = goodsDescription;
        this.goodsPrice = goodsPrice;
        this.pictureUrl = pictureUrl;
    }

    public Goods(String goodsId, String goodsName, String goodsDescription, String vendorsId, double goodsPrice, boolean discount, String details, String pictureUrl) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsDescription = goodsDescription;
        this.vendorsId = vendorsId;
        this.goodsPrice = goodsPrice;
        this.discount = discount;
        this.details = details;
        this.pictureUrl = pictureUrl;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public String getDetails() {
        return details;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }
}
