package com.hotel.projectHotel.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Apartment {
    @Id
    int id;
    @Column
    int comfortableRank;
    @Column
    int sleepingPlaces;
    @Column
    int price;


}
