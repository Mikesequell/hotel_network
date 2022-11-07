package com.hotel.projectHotel.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Customer {
    @Id
    int id;
    @Column
    String passport;
    @ManyToOne
    CustomerStatus customerStatus;
}
