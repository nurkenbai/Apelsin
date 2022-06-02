package com.company.entity;

import com.company.enums.SmsStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "sms_table")
public class SmsEntity extends BaseEntity {
    @Column
    private String phone;
    @Column
    private String content;
    @Column
    @Enumerated(EnumType.STRING)
    private SmsStatus status;
}
