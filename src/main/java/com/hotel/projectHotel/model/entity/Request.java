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
    @Column
    private int comfortableRank;
    @Column
    private int sleepingPlaces;
    @Column
    private Date arrivalDate;
    @Column
    private Date departureDate;
    @Column
    private int offeredPriceForPayment;
    @Column
    private boolean paymentStatus;
    @ManyToOne
    private User userId;
    @OneToOne
    private Hotel hotelId;
    @OneToOne
    private Apartment apartmentId;
}
