package com.hotel.projectHotel.model.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
}
