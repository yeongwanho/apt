package com.project.apt.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Apt {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "city_l")
    private String cityL;

    @Column(name = "city_m")
    private String cityM;

    @Column(name = "city_s")
    private String cityS;

    private String aptName;

    private String dedicatedArea;

    private String ContractDate;

    private String price;

    private String aptRow;

    private String aptYear;

    private String roadName;

    private String etc;
}
