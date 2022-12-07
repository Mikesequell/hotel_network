package com.hotel.projectHotel.service.impl;

import com.hotel.projectHotel.dto.ApartmentDto;
import com.hotel.projectHotel.dto.FreeApartmentDto;
import com.hotel.projectHotel.model.repositiry.ApartmentRepository;
import com.hotel.projectHotel.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepository apartmentRepository;

    @Override
    public List<ApartmentDto> getAllApartmentsByHotelId(Integer id) {
        log.info("Getting all apartments by hotel id");
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
        log.info("Getting free apartments by hotel id");
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

    @Override
    public List<ApartmentDto> getAllApartments() {
        log.info("Getting all apartments");
        var apartments = apartmentRepository.findAll();
        var apartmentsDto = new ArrayList<ApartmentDto>();
        apartments.forEach(apartment -> {
            var apartmentDto = new ApartmentDto();
            apartmentDto.setId(apartment.getId());
            apartmentDto.setSleepingPlaces(apartment.getSleepingPlaces());
            apartmentDto.setComfortableRank(apartment.getComfortableRank());
            apartmentDto.setPrice(apartment.getPrice());
            apartmentDto.setStatusId(apartment.getStatusId());
            apartmentDto.setHotelId(apartment.getHotelId());
            apartmentsDto.add(apartmentDto);
        });
        return apartmentsDto;
    }
}
