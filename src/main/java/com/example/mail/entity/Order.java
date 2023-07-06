package com.example.mail.entity;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String OrderNo;

    private String orderStatus;

    private  Date createTime;

    private Date modifyTime;


}
