package com.hotel.projectHotel.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String address;
    @Column(name = "all_quantity_apartments")
    private Integer allQuantityApartments;
    @Column(name = "free_apartments")
    private Integer freeApartments;
//    @Column(name = "occupied_apartments")
//    private int occupiedApartments;
}
