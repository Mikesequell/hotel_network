package com.hotel.projectHotel.service.impl;

import com.hotel.projectHotel.dto.AdminRequestDto;
import com.hotel.projectHotel.dto.CreateRequestDto;
import com.hotel.projectHotel.model.entity.Apartment;
import com.hotel.projectHotel.model.entity.Request;
import com.hotel.projectHotel.model.entity.Status;
import com.hotel.projectHotel.model.repositiry.RequestRepository;
import com.hotel.projectHotel.model.repositiry.StatusRepository;
import com.hotel.projectHotel.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {
    private final RequestRepository requestRepository;
    private final StatusRepository statusRepository;

    @Override
    public void createRequest(CreateRequestDto requestDto) {
        var request = new Request();
        var apartment = new Apartment();
        apartment.setHotelId(requestDto.getApartment().getHotelId());
        apartment.setComfortableRank(requestDto.getApartment().getComfortableRank());
        apartment.setSleepingPlaces(requestDto.getApartment().getSleepingPlaces());
        request.setApartmentId(apartment);
        request.setArrivalDate(requestDto.getArrivalDate());
        request.setDepartureDate(requestDto.getDepartureDate());
        request.setUserId(requestDto.getUserId());

        request.setStatusId(statusRepository.getByNameLikeIgnoreCase("created"));
        requestRepository.saveAndFlush(request);
    }

    @Override
    public List<AdminRequestDto> getAllRequests() {
        var allRequests = requestRepository.findAll();
        var allAdminRequestsDto = new ArrayList<AdminRequestDto>();
        allRequests.forEach(request -> {
            var adminRequestDto = new AdminRequestDto();
            adminRequestDto.setId(request.getId());
            adminRequestDto.setArrivalDate(request.getArrivalDate());
            adminRequestDto.setDepartureDate(request.getDepartureDate());
            adminRequestDto.setOfferedPriceForPayment(request.getOfferedPriceForPayment());
            adminRequestDto.setStatus(request.getStatusId());
            adminRequestDto.setUserId(request.getUserId());
            adminRequestDto.setApartmentId(request.getApartmentId());
            allAdminRequestsDto.add(adminRequestDto);
        });
        return allAdminRequestsDto;
    }
}
