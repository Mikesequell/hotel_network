package com.hotel.projectHotel.dto;

import com.hotel.projectHotel.model.entity.Apartment;
import com.hotel.projectHotel.model.entity.Status;
import com.hotel.projectHotel.model.entity.User;
import lombok.Data;

import java.sql.Date;

@Data
public class AdminRequestDto {
    private Long id;
    private Date arrivalDate;
    private Date departureDate;
    private Integer offeredPriceForPayment;
    private Status statusId;
    private User userId;
    private Apartment apartmentId;
}
