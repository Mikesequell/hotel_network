package com.hotel.projectHotel.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "comfortable_rank")
    private Integer comfortableRank;
    @Column(name = "sleeping_places")
    private Integer sleepingPlaces;
    @Column(name = "arrival_date")
    private Date arrivalDate;
    @Column(name = "departure_date")
    private Date departureDate;
    @Column(name = "offered_price_for_payment")
    private Integer offeredPriceForPayment;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status")
    private Status status;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User userId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "offered_hotel_id")
    private Hotel hotelId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "offered_apartment_id")
    private Apartment apartmentId;
}
