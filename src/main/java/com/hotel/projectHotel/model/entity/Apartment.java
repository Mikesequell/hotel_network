package com.hotel.projectHotel.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "comfortable_rank")
    private int comfortableRank;
    @Column(name = "sleeping_places")
    private int sleepingPlaces;
    @Column
    private int price;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotelId;

}
