package com.hotel.projectHotel.dto;

import com.hotel.projectHotel.model.entity.Hotel;
import com.hotel.projectHotel.model.entity.Status;
import lombok.Data;

@Data
public class FreeApartmentDto {
    private Long id;
    private Integer comfortableRank;
    private Integer sleepingPlaces;
    private Integer price;
    private Status statusId;
    private Hotel hotelId;
}
