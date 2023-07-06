package com.example.mail.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Column(name = "city_id")
    private String cityId;
    @Column(name = "city_name")
    private String cityName;

}
