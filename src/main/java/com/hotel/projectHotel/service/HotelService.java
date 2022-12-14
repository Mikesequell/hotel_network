package com.hotel.projectHotel.service;

import com.hotel.projectHotel.dto.HotelDto;
import com.hotel.projectHotel.dto.HotelRequestDto;
import com.hotel.projectHotel.model.entity.Hotel;
import com.hotel.projectHotel.model.repositiry.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HotelService {
    HotelDto findById(Integer id);
    List<HotelDto> getAllHotels();
    List<HotelRequestDto> getHotelsRequestDto();
}
