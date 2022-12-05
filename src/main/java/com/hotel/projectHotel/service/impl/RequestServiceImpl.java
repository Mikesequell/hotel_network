package com.hotel.projectHotel.service.impl;

import com.hotel.projectHotel.dto.AdminRequestDto;
import com.hotel.projectHotel.dto.CreateRequestDto;
import com.hotel.projectHotel.model.entity.Apartment;
import com.hotel.projectHotel.model.entity.Request;
import com.hotel.projectHotel.model.repositiry.ApartmentRepository;
import com.hotel.projectHotel.model.repositiry.RequestRepository;
import com.hotel.projectHotel.model.repositiry.StatusRepository;
import com.hotel.projectHotel.service.RequestService;
import com.hotel.projectHotel.utils.CalculationNumberDays;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Apartment> apartmentsFree = searchFreeApartmentsByHotelComfortableRankSleepingPlaces(requestDto);
        if (apartmentsFree.size() != 0) {
            request.setApartmentId(apartmentsFree.get(0));
            request.setArrivalDate(requestDto.getArrivalDate());
            request.setDepartureDate(requestDto.getDepartureDate());
            request.setUserId(requestDto.getUserId());
            request.setOfferedPriceForPayment(
                    apartmentsFree.get(0).getPrice() * (int) CalculationNumberDays.getDayCount(requestDto.getArrivalDate(), requestDto.getDepartureDate())
            );
            request.setStatusId(statusRepository.getByNameLikeIgnoreCase("awaiting payment"));
        } else {
            List<Apartment> offeredFreeApartmentsByHotelSleepingPlaces = searchFreeApartmentsByHotelSleepingPlaces(requestDto);
            if (offeredFreeApartmentsByHotelSleepingPlaces.size() != 0) {
                request.setApartmentId(offeredFreeApartmentsByHotelSleepingPlaces.get(0));
                request.setArrivalDate(requestDto.getArrivalDate());
                request.setDepartureDate(requestDto.getDepartureDate());
                request.setUserId(requestDto.getUserId());
                request.setStatusId(statusRepository.getByNameLikeIgnoreCase("in processing"));
            } else {
                List<Apartment> offeredFreeApartmentsBySleepingPlaces = searchFreeApartmentsBySleepingPlaces(requestDto);
                if (offeredFreeApartmentsBySleepingPlaces.size() != 0) {
                    request.setApartmentId(offeredFreeApartmentsBySleepingPlaces.get(0));
                    request.setArrivalDate(requestDto.getArrivalDate());
                    request.setDepartureDate(requestDto.getDepartureDate());
                    request.setUserId(requestDto.getUserId());
                    request.setStatusId(statusRepository.getByNameLikeIgnoreCase("in processing"));
                } else {
                    List<Apartment> offeredAnyApartmentsByHotelSleepingPlaces = searchAnyApartmentsByHotelSleepingPlaces(requestDto);
                    request.setApartmentId(offeredAnyApartmentsByHotelSleepingPlaces.get(0));
                    request.setArrivalDate(requestDto.getArrivalDate());
                    request.setDepartureDate(requestDto.getDepartureDate());
                    request.setUserId(requestDto.getUserId());
                    request.setStatusId(statusRepository.getByNameLikeIgnoreCase("in processing"));
                }
            }
        }

        requestRepository.saveAndFlush(request);
    }

    private List<Apartment> searchFreeApartmentsByHotelComfortableRankSleepingPlaces(CreateRequestDto requestDto) {
        List<Apartment> apartmentsFree = apartmentRepository.findByHotelId_IdAndComfortableRankAndSleepingPlacesAndStatusId_NameIgnoreCase(
                requestDto.getApartment().getHotelId().getId(),
                requestDto.getApartment().getComfortableRank(),
                requestDto.getApartment().getSleepingPlaces(),
                "free"
        );
        return apartmentsFree;
    }

    private List<Apartment> searchFreeApartmentsByHotelSleepingPlaces(CreateRequestDto requestDto) {
        List<Apartment> apartmentsFree = apartmentRepository.findByHotelId_IdAndSleepingPlacesAndStatusId_NameIgnoreCase(
                requestDto.getApartment().getHotelId().getId(),
                requestDto.getApartment().getSleepingPlaces(),
                "free"
        );
        return apartmentsFree;
    }

    private List<Apartment> searchFreeApartmentsBySleepingPlaces(CreateRequestDto requestDto) {
        List<Apartment> apartmentsFree = apartmentRepository.findBySleepingPlacesAndStatusId_NameIgnoreCase(
                requestDto.getApartment().getSleepingPlaces(),
                "free"
        );
        return apartmentsFree;
    }

    private List<Apartment> searchAnyApartmentsByHotelSleepingPlaces(CreateRequestDto requestDto) {
        List<Apartment> apartmentsFree = apartmentRepository.findByHotelId_IdAndSleepingPlacesAndStatusId_NameIgnoreCaseNotLike(
                requestDto.getApartment().getHotelId().getId(),
                requestDto.getApartment().getSleepingPlaces(),
                "free"
        );
        return apartmentsFree;
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
            adminRequestDto.setStatusId(request.getStatusId());
            adminRequestDto.setUserId(request.getUserId());
            adminRequestDto.setApartmentId(request.getApartmentId());
            allAdminRequestsDto.add(adminRequestDto);
        });
        return allAdminRequestsDto;
    }

    @Override
    public List<AdminRequestDto> getAllRequestsInProcessing() {
        var allRequestsInProcessing = requestRepository.findByStatusId_NameIgnoreCase("in processing");
        var allAdminRequestsInProcessingDto = new ArrayList<AdminRequestDto>();
        allRequestsInProcessing.forEach(request -> {
            var adminRequestDto = new AdminRequestDto();
            adminRequestDto.setId(request.getId());
            adminRequestDto.setArrivalDate(request.getArrivalDate());
            adminRequestDto.setDepartureDate(request.getDepartureDate());
            adminRequestDto.setOfferedPriceForPayment(request.getOfferedPriceForPayment());
            adminRequestDto.setStatusId(request.getStatusId());
            adminRequestDto.setUserId(request.getUserId());
            adminRequestDto.setApartmentId(request.getApartmentId());
            allAdminRequestsInProcessingDto.add(adminRequestDto);
        });
        return allAdminRequestsInProcessingDto;
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
            adminRequestDto.setStatusId(request.getStatusId());
            adminRequestDto.setUserId(request.getUserId());
            adminRequestDto.setApartmentId(request.getApartmentId());
            allAdminRequestsInprocessingDto.add(adminRequestDto);
        });
        return allAdminRequestsInprocessingDto;
    }

    @Override
    public AdminRequestDto getById(Long id) {
        var request = requestRepository.findById(id);
        var adminRequestDto = new AdminRequestDto();
        adminRequestDto.setId(request.getId());
        adminRequestDto.setArrivalDate(request.getArrivalDate());
        adminRequestDto.setDepartureDate(request.getDepartureDate());
        adminRequestDto.setOfferedPriceForPayment(request.getOfferedPriceForPayment());
        adminRequestDto.setStatusId(request.getStatusId());
        adminRequestDto.setUserId(request.getUserId());
        adminRequestDto.setApartmentId(request.getApartmentId());
        return adminRequestDto;
    }

    @Override
    public void submitRequestEdit(AdminRequestDto adminRequestDto) {
        var request = requestRepository.findById(adminRequestDto.getId());
        request.setStatusId(statusRepository.getByNameLikeIgnoreCase("response awaiting"));
        request.setApartmentId(apartmentRepository.findById(adminRequestDto.getApartmentId().getId()));
        request.setOfferedPriceForPayment(
                request.getApartmentId().getPrice() *
                        (int) CalculationNumberDays.getDayCount(request.getArrivalDate(), request.getDepartureDate()));
        requestRepository.saveAndFlush(request);
    }

    @Override
    public void applyRequest(AdminRequestDto adminRequestDto) {
        Request request = requestRepository.findById(adminRequestDto.getId());
        request.setStatusId(statusRepository.getByNameLikeIgnoreCase("awaiting payment"));
        requestRepository.saveAndFlush(request);
    }

    @Override
    public void payRequest(AdminRequestDto adminRequestDto) {
        Request request = requestRepository.findById(adminRequestDto.getId());
        request.setStatusId(statusRepository.getByNameLikeIgnoreCase("paid"));
        request.getApartmentId().setStatusId(statusRepository.getByNameLikeIgnoreCase("occupied"));
        requestRepository.saveAndFlush(request);
    }

    @Override
    public void cancelRequest(AdminRequestDto adminRequestDto) {
        Request request = requestRepository.findById(adminRequestDto.getId());
        request.setStatusId(statusRepository.getByNameLikeIgnoreCase("cancelled"));
        requestRepository.saveAndFlush(request);
    }
}
