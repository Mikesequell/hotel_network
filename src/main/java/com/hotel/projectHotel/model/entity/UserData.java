package com.hotel.projectHotel.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "user_data")
public class UserData {
    @Id
    int userId;
    @Column
    String name;
    @Column
    String surname;
    @Column
    String passport;
    @Column
    String telephoneNumber;
}
