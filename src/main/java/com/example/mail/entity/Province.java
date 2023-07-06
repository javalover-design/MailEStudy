package com.example.mail.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Province {
    @Column(name = "province_id")
    private String provinceId;

    @Column(name = "province_name")
    private String provinceName;
}
