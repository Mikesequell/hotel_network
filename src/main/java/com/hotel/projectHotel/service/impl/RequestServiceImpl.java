package com.hotel.projectHotel.service.impl;

import com.hotel.projectHotel.dto.CreateRequestDto;
import com.hotel.projectHotel.model.entity.Request;
import com.hotel.projectHotel.model.entity.Status;
import com.hotel.projectHotel.model.repositiry.RequestRepository;
import com.hotel.projectHotel.model.repositiry.StatusRepository;
import com.hotel.projectHotel.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {
    private final RequestRepository requestRepository;
    private final StatusRepository statusRepository;

    @Override
    public void createRequest(CreateRequestDto newRequest) {
        var request = new Request();
        request.setComfortableRank(newRequest.getComfortableRank());
        request.setSleepingPlaces(newRequest.getSleepingPlaces());
        request.setArrivalDate(newRequest.getArrivalDate());
        request.setDepartureDate(newRequest.getDepartureDate());
        request.setUserId(newRequest.getUserId());
        request.setHotelId(newRequest.getHotelId());
        request.setStatus(statusRepository.getByStatusLikeIgnoreCase("created"));
        requestRepository.saveAndFlush(request);
    }
}
