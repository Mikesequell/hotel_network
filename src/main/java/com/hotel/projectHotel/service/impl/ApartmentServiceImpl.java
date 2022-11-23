package com.hotel.projectHotel.service.impl;

import com.hotel.projectHotel.dto.ApartmentDto;
import com.hotel.projectHotel.dto.FreeApartmentDto;
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
            apartmentDto.setStatusId(apartment.getStatusId());
            apartmentsDto.add(apartmentDto);
        });
        return apartmentsDto;
    }

    @Override
    public List<FreeApartmentDto> getFreeApartmentsByHotelId(Integer id) {
//        var apartments = apartmentRepository.findByStatusId_Name("free");
        var apartments = apartmentRepository.findByHotelId_IdAndStatusId_NameIgnoreCase(id, "free");
        var freeApartmentDto = new ArrayList<FreeApartmentDto>();
        apartments.forEach(apartment -> {
            FreeApartmentDto apartmentDto = new FreeApartmentDto();
            apartmentDto.setId(apartment.getId());
            apartmentDto.setComfortableRank(apartment.getComfortableRank());
            apartmentDto.setSleepingPlaces(apartment.getSleepingPlaces());
            apartmentDto.setPrice(apartment.getPrice());
            apartmentDto.setHotelId(apartment.getHotelId());
            apartmentDto.setStatusId(apartment.getStatusId());
            freeApartmentDto.add(apartmentDto);

        });
        return freeApartmentDto;
    }
}
