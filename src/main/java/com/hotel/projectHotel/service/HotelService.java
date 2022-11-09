package com.hotel.projectHotel.service;

import com.hotel.projectHotel.model.entity.Hotel;
import com.hotel.projectHotel.model.repositiry.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HotelService {
    Hotel findById(Integer id);
    List<Hotel> findAll();
}
