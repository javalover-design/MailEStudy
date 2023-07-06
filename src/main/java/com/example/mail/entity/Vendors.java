package com.example.mail.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.print.attribute.standard.MediaSize;
import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@Entity
@Getter
public class Vendors implements Serializable {

    private static final long serialVersionUID = 1L;
    private String vendorsId;


    private String vendorsName;


    private String vendorsAddress;


    private String vendorsPhone;


    private String vendorsDescription;


    private String vendorsZip;


    private String goodsList;

    public Vendors(String vendorsId,String vendorsName, String vendorsAddress, String vendorsPhone, String vendorsDescription, String vendorsZip, String goodsArrayList) {
        this.vendorsId=vendorsId;
        this.vendorsName = vendorsName;
        this.vendorsAddress = vendorsAddress;
        this.vendorsPhone = vendorsPhone;
        this.vendorsDescription = vendorsDescription;
        this.vendorsZip = vendorsZip;
        this.goodsList = goodsArrayList;
    }



    public Vendors(String vendorsName, String vendorsPhone) {
        this.vendorsName = vendorsName;
        this.vendorsPhone = vendorsPhone;
    }

    public String getVendorsId() {
        return vendorsId;
    }
}
