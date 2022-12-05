package com.hotel.projectHotel.dto;

import com.hotel.projectHotel.model.entity.Apartment;
import com.hotel.projectHotel.model.entity.Hotel;
import com.hotel.projectHotel.model.entity.Status;
import com.hotel.projectHotel.model.entity.User;
import lombok.Data;

@Data
public class ApartmentDto {
    private Long id;
    private Integer comfortableRank;
    private Integer sleepingPlaces;
    private Integer price;
    private Status statusId;
    private Hotel hotelId;
}
