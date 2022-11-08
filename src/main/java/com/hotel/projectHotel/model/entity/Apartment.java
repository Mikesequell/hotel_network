package com.hotel.projectHotel.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int comfortableRank;
    @Column
    private int sleepingPlaces;
    @Column
    private int price;
    @ManyToOne
    private User userId;
    @ManyToOne
    private Hotel hotelId;

}
