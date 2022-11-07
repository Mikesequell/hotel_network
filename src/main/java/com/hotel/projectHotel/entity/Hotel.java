package com.hotel.projectHotel.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Hotel {
    @Id
    int id;
    @Column
    String name;
    @Column
    String address;
    @Column
    int allQuantityApartments;
    @Column
    int freeApartments;
    @Column
    int reservedApartments;
    @Column
    int occupiedApartments;
}
