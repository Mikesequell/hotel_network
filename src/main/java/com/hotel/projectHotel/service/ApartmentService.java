package com.hotel.projectHotel.service;

import com.hotel.projectHotel.dto.ApartmentDto;
import com.hotel.projectHotel.dto.FreeApartmentDto;

import java.util.List;

public interface ApartmentService {
    List<ApartmentDto> getAllApartmentsByHotelId(Integer id);
    List<FreeApartmentDto> getFreeApartmentsByHotelId(Integer id);
}
