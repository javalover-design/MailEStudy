package com.example.mail.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    @Column(name = "region_id")
    private String regionId;
    @Column(name = "region_name")
    private String regionName;
}
