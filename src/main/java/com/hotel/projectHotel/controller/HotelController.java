package com.hotel.projectHotel.controller;

import com.hotel.projectHotel.model.entity.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.hotel.projectHotel.service.HotelService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @GetMapping("/hotel/{id}")
    public Hotel getHotel(@PathVariable Integer id) {
        
        return hotelService.findById(id);
    }

    @GetMapping("/hotel")
    public List<Hotel> getAllHotel() {
        return hotelService.findAll();
    }
}
