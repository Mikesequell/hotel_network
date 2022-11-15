package com.hotel.projectHotel.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "user_data")
public class UserData {
    @Id
    private Integer id;
    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id")
    private User userId;

//    @Id
//    @Column(name = "user_id")
//    int userId;
    @Column
    String name;
    @Column
    String surname;
    @Column
    String passport;
    @Column(name = "telephone_number")
    String telephoneNumber;
}
