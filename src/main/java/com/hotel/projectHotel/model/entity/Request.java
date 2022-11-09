package com.hotel.projectHotel.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Request {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "comfortable_rank")
    private int comfortableRank;
    @Column(name = "sleeping_places")
    private int sleepingPlaces;
    @Column(name = "arrival_date")
    private Date arrivalDate;
    @Column(name = "departure_date")
    private Date departureDate;
    @Column(name = "offered_price_for_payment")
    private int offeredPriceForPayment;
    @Column
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotelId;
    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartmentId;
}
