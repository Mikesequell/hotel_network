package com.hotel.projectHotel.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Request {
    @Id
    int id;
    @Column
    int comfortableRank;
    @Column
    int sleepingPlaces;
    @Column
    String arrivalDate;
    @Column
    String departureDate;
    @Column
    int daysQuantity;
    @Column
    int price;
    @Column
    boolean paymentStatus;
    @ManyToOne
    Customer customerId;
}
