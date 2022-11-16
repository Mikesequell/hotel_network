package com.hotel.projectHotel.service.impl;

import com.hotel.projectHotel.dto.ApartmentDto;
import com.hotel.projectHotel.dto.ApartmentWithoutUserDto;
import com.hotel.projectHotel.model.repositiry.ApartmentRepository;
import com.hotel.projectHotel.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepository apartmentRepository;

    @Override
    public List<ApartmentDto> getAllApartmentsByHotelId(Integer id) {
        var apartments = apartmentRepository.findByHotelIdId(id);
        var apartmentsDto = new ArrayList<ApartmentDto>();
        apartments.forEach(apartment -> {
            ApartmentDto apartmentDto = new ApartmentDto();
            apartmentDto.setId(apartment.getId());
            apartmentDto.setPrice(apartment.getPrice());
            apartmentDto.setComfortableRank(apartment.getComfortableRank());
            apartmentDto.setSleepingPlaces(apartment.getSleepingPlaces());
            apartmentDto.setUserId(apartment.getUserId());
            apartmentsDto.add(apartmentDto);
        });
        return apartmentsDto;
    }

    @Override
    public List<ApartmentWithoutUserDto> getFreeApartmentsByHotelId(Integer id) {
        var apartments = apartmentRepository.findByHotelIdId(id);
        var apartmentsWithoutUserDto = new ArrayList<ApartmentWithoutUserDto>();
        apartments.forEach(apartment -> {
            if (apartment.getUserId() == null) {
                ApartmentWithoutUserDto apartmentDto = new ApartmentWithoutUserDto();
                apartmentDto.setId(apartment.getId());
                apartmentDto.setPrice(apartment.getPrice());
                apartmentDto.setComfortableRank(apartment.getComfortableRank());
                apartmentDto.setSleepingPlaces(apartment.getSleepingPlaces());
                apartmentsWithoutUserDto.add(apartmentDto);
            }
        });
        return apartmentsWithoutUserDto;
    }
}
