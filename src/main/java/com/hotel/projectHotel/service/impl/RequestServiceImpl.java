package com.hotel.projectHotel.service.impl;

import com.hotel.projectHotel.dto.AdminRequestDto;
import com.hotel.projectHotel.dto.CreateRequestDto;
import com.hotel.projectHotel.model.entity.Apartment;
import com.hotel.projectHotel.model.entity.Request;
import com.hotel.projectHotel.model.repositiry.ApartmentRepository;
import com.hotel.projectHotel.model.repositiry.RequestRepository;
import com.hotel.projectHotel.model.repositiry.StatusRepository;
import com.hotel.projectHotel.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {
    private final RequestRepository requestRepository;
    private final StatusRepository statusRepository;
    private final ApartmentRepository apartmentRepository;

    @Override
    public void createRequest(CreateRequestDto requestDto) {
        var request = new Request();
        List<Apartment> apartmentsFree = apartmentRepository.findByHotelId_IdAndComfortableRankAndSleepingPlacesAndStatusId_NameIgnoreCase(
                requestDto.getApartment().getHotelId().getId(),
                requestDto.getApartment().getComfortableRank(),
                requestDto.getApartment().getSleepingPlaces(),
                "free"
        );
        if (apartmentsFree != null || apartmentsFree.size() != 0) {
            request.setApartmentId(apartmentsFree.get(0));
            request.setArrivalDate(requestDto.getArrivalDate());
            request.setDepartureDate(requestDto.getDepartureDate());
            request.setUserId(requestDto.getUserId());
            request.setStatusId(statusRepository.getByNameLikeIgnoreCase("awaiting payment"));
        } else if (apartmentsFree == null || apartmentsFree.size() == 0) {
            List<Apartment> apartmentsNotFree = apartmentRepository.findByHotelId_IdAndComfortableRankAndSleepingPlacesAndStatusId_NameIgnoreCaseNotLike(
                    requestDto.getApartment().getHotelId().getId(),
                    requestDto.getApartment().getComfortableRank(),
                    requestDto.getApartment().getSleepingPlaces(),
                    "free"
            );
            request.setApartmentId(apartmentsNotFree.get(0));
            request.setArrivalDate(requestDto.getArrivalDate());
            request.setDepartureDate(requestDto.getDepartureDate());
            request.setUserId(requestDto.getUserId());
            request.setStatusId(statusRepository.getByNameLikeIgnoreCase("in processing"));
        }
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

    @Override
    public List<AdminRequestDto> getAllRequestsInProcessing() {
        var allRequestsInProcessing = requestRepository.findByStatusId_NameIgnoreCase("in processing");
        var allAdminRequestsInprocessingDto = new ArrayList<AdminRequestDto>();
        allRequestsInProcessing.forEach(request -> {
            var adminRequestDto = new AdminRequestDto();
            adminRequestDto.setId(request.getId());
            adminRequestDto.setArrivalDate(request.getArrivalDate());
            adminRequestDto.setDepartureDate(request.getDepartureDate());
            adminRequestDto.setOfferedPriceForPayment(request.getOfferedPriceForPayment());
            adminRequestDto.setStatus(request.getStatusId());
            adminRequestDto.setUserId(request.getUserId());
            adminRequestDto.setApartmentId(request.getApartmentId());
            allAdminRequestsInprocessingDto.add(adminRequestDto);
        });
        return allAdminRequestsInprocessingDto;
    }

    @Override
    public List<AdminRequestDto> getAllRequestsByUser(Long id) {
        var allRequestsByUserId = requestRepository.findByUserId_Id(id);
        var allAdminRequestsInprocessingDto = new ArrayList<AdminRequestDto>();
        allRequestsByUserId.forEach(request -> {
            var adminRequestDto = new AdminRequestDto();
            adminRequestDto.setId(request.getId());
            adminRequestDto.setArrivalDate(request.getArrivalDate());
            adminRequestDto.setDepartureDate(request.getDepartureDate());
            adminRequestDto.setOfferedPriceForPayment(request.getOfferedPriceForPayment());
            adminRequestDto.setStatus(request.getStatusId());
            adminRequestDto.setUserId(request.getUserId());
            adminRequestDto.setApartmentId(request.getApartmentId());
            allAdminRequestsInprocessingDto.add(adminRequestDto);
        });
        return allAdminRequestsInprocessingDto;
    }
}
