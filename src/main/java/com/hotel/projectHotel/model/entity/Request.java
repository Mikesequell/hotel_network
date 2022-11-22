package com.hotel.projectHotel.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "arrival_date")
    private Date arrivalDate;
    @Column(name = "departure_date")
    private Date departureDate;
    @Column(name = "offered_price_for_payment")
    private Integer offeredPriceForPayment;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private Status statusId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User userId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apartment_id")
    private Apartment apartmentId;
}
