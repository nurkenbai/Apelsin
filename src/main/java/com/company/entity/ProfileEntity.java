package com.company.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "profile")
public class ProfileEntity extends BestEntity{
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String phone;

}
