package com.hotel.projectHotel.service.impl;

import com.hotel.projectHotel.dto.HotelDto;
import com.hotel.projectHotel.dto.HotelRequestDto;
import com.hotel.projectHotel.model.entity.Hotel;
import com.hotel.projectHotel.model.repositiry.HotelRepository;
import com.hotel.projectHotel.model.repositiry.UserRepository;
import com.hotel.projectHotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Override
    public HotelDto findById(Integer id) {
        log.info("Finding hotel by id");
        var hotel = hotelRepository.findById(id).get();
        HotelDto hotelDto = new HotelDto();
        hotelDto.setId(hotel.getId());
        hotelDto.setAddress(hotel.getAddress());
        hotelDto.setName(hotel.getName());
        hotelDto.setAllQuantityApartments(hotel.getAllQuantityApartments());
        return hotelDto;
    }

    @Override
    public List<HotelDto> getAllHotels() {
        log.info("Getting all hotels");
        var hotels = hotelRepository.findAll();
        var hotelsDto = new ArrayList<HotelDto>();
        hotels.forEach(hotel -> {
            var hotelDto = new HotelDto();
            hotelDto.setId(hotel.getId());
            hotelDto.setName(hotel.getName());
            hotelDto.setAddress(hotel.getAddress());
            hotelDto.setAllQuantityApartments(hotel.getAllQuantityApartments());
            hotelsDto.add(hotelDto);
        });
        return hotelsDto;
    }

    @Override
    public List<HotelRequestDto> getHotelsRequestDto() {
        var hotels = hotelRepository.findAll();
        var hotelsRequestDto = new ArrayList<HotelRequestDto>();
        hotels.forEach(hotel -> {
            var hotelRequestDto = new HotelRequestDto();
            hotelRequestDto.setId(hotel.getId());
            hotelRequestDto.setName(hotel.getName());
            hotelsRequestDto.add(hotelRequestDto);
        });
        return hotelsRequestDto;
    }

}
