package com.hotel.projectHotel.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Login {
    @Id
    int id;
    @Column
    String login;
    @Column
    String password;
    @OneToOne
    Customer customerId;
}
