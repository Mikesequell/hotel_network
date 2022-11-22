package com.hotel.projectHotel.dto;

import com.hotel.projectHotel.model.entity.Hotel;
import lombok.Data;

@Data
public class ApartmentCreateRequestDto {
    private Integer comfortableRank;
    private Integer sleepingPlaces;
    private Hotel hotelId;
}
