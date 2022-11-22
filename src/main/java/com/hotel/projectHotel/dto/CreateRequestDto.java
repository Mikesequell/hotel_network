package com.hotel.projectHotel.dto;

import com.hotel.projectHotel.model.entity.Hotel;
import com.hotel.projectHotel.model.entity.User;
import com.hotel.projectHotel.utils.CurrentDateToString;
import lombok.Data;

import java.sql.Date;

@Data
public class CreateRequestDto {
    
    private Date arrivalDate;
    private Date departureDate;
    private User userId;
    private String currentDate = CurrentDateToString.execute();
    private ApartmentCreateRequestDto apartment;
}
