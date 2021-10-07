package com.project.apt.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Member {
    @Id @GeneratedValue
    @Column
    private Long id;

    private String name;

    private String password;

    private String loginId;
}
