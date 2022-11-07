package com.hotel.projectHotel.model.entity;

import lombok.Data;

import javax.persistence.*;

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
    @ManyToOne
    Customer customerId;
    @ManyToOne
    Hotel hotelId;

}
