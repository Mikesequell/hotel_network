package com.hotel.projectHotel.dto;

import com.hotel.projectHotel.model.entity.Hotel;
import com.hotel.projectHotel.model.entity.User;
import com.hotel.projectHotel.utils.CurrentDateToString;
import lombok.Data;

import java.sql.Date;

@Data
public class CreateRequestDto {
    private Integer comfortableRank;
    private Integer sleepingPlaces;
    private Date arrivalDate;
    private Date departureDate;
    private User userId;
    private Hotel hotelId;
    private String currentDate = CurrentDateToString.execute();
}
