package com.hotel.projectHotel.dto;

import com.hotel.projectHotel.model.entity.User;
import lombok.Data;

@Data
public class ApartmentWithoutUserDto {
    private Integer id;
    private Integer comfortableRank;
    private Integer sleepingPlaces;
    private Integer price;
}
