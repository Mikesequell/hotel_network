package com.hotel.projectHotel.service.impl;

import com.hotel.projectHotel.dto.HotelDto;
import com.hotel.projectHotel.model.entity.Hotel;
import com.hotel.projectHotel.model.repositiry.HotelRepository;
import com.hotel.projectHotel.model.repositiry.UserRepository;
import com.hotel.projectHotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Override
    public Hotel findById(Integer id) {
        return hotelRepository.findById(id).get();
    }

    @Override
    public List<HotelDto> getAllHotels() {
        var hotels = hotelRepository.findAll();
        var hotelsDto = new ArrayList<HotelDto>();
        hotels.forEach(hotel -> {
            var hotelDto = new HotelDto();
            hotelDto.setId(hotel.getId());
            hotelDto.setName(hotel.getName());
            hotelDto.setName(hotel.getName());
            hotelDto.setFreeApartments(hotel.getFreeApartments());
            hotelsDto.add(hotelDto);
        });
        return hotelsDto;
    }

}
