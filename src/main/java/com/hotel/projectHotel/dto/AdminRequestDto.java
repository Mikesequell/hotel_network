package com.hotel.projectHotel.dto;

import com.hotel.projectHotel.model.entity.Apartment;
import com.hotel.projectHotel.model.entity.Hotel;
import com.hotel.projectHotel.model.entity.Status;
import com.hotel.projectHotel.model.entity.User;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Data
public class AdminRequestDto {
    private Long id;
    private Integer comfortableRank;
    private Integer sleepingPlaces;
    private Date arrivalDate;
    private Date departureDate;
    private Integer offeredPriceForPayment;
    private Status status;
    private User userId;
    private Hotel hotelId;
    private Apartment apartmentId;
}
