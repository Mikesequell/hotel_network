package com.hotel.projectHotel.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String address;
    @Column(name = "all_quantity_apartments")
    private Integer allQuantityApartments;
    @Column(name = "free_apartments")
    private int freeApartments;
    @Column(name = "occupied_apartments")
    private int occupiedApartments;
}
