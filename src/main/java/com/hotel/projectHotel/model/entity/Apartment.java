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
    @JoinColumn(name = "userId")
    private User userId;
    @ManyToOne
    @JoinColumn(name = "hotelId")
    private Hotel hotelId;

}
