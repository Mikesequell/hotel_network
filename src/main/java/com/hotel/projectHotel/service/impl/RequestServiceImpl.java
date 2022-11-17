package com.hotel.projectHotel.service.impl;

import com.hotel.projectHotel.dto.CreateRequestDto;
import com.hotel.projectHotel.model.entity.Request;
import com.hotel.projectHotel.model.repositiry.RequestRepository;
import com.hotel.projectHotel.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {
    private final RequestRepository requestRepository;

    @Override
    public void createNewRequest(CreateRequestDto newRequestDto) {
        var request = new Request();
        request.setComfortableRank(newRequestDto.getComfortableRank());
        request.setSleepingPlaces(newRequestDto.getSleepingPlaces());
        request.setArrivalDate(newRequestDto.getArrivalDate());
        request.setDepartureDate(newRequestDto.getDepartureDate());
        request.setUserId(newRequestDto.getUserId());
        request.setHotelId(newRequestDto.getHotelId());
        requestRepository.saveAndFlush(request);
    }
}
