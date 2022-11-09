package com.hotel.projectHotel.service.impl;

import com.hotel.projectHotel.model.entity.Hotel;
import com.hotel.projectHotel.model.repositiry.HotelRepository;
import com.hotel.projectHotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }
}
