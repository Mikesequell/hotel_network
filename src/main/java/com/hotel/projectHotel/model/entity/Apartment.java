package com.hotel.projectHotel.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "comfortable_rank")
    private Integer comfortableRank;
    @Column(name = "sleeping_places")
    private Integer sleepingPlaces;
    @Column
    private Integer price;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private Status statusId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private Hotel hotelId;

}
