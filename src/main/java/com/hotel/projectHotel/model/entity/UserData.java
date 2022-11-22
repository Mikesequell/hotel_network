package com.hotel.projectHotel.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "user_data")
public class UserData {
    @Id
    private Long id;
    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id")
    private User userId;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String passport;
    @Column(name = "telephone_number")
    private String telephoneNumber;
}
