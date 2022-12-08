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
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {
    private final RequestRepository requestRepository;
    private final StatusRepository statusRepository;
    private final ApartmentRepository apartmentRepository;

    @Override
    public void createRequest(CreateRequestDto requestDto) {
        log.info("Creating new request");
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
        return apartmentRepository.findByHotelId_IdAndComfortableRankAndSleepingPlacesAndStatusId_NameIgnoreCase(
                requestDto.getApartment().getHotelId().getId(),
                requestDto.getApartment().getComfortableRank(),
                requestDto.getApartment().getSleepingPlaces(),
                "free"
        );
    }

    private List<Apartment> searchFreeApartmentsByHotelSleepingPlaces(CreateRequestDto requestDto) {
        return apartmentRepository.findByHotelId_IdAndSleepingPlacesAndStatusId_NameIgnoreCase(
                requestDto.getApartment().getHotelId().getId(),
                requestDto.getApartment().getSleepingPlaces(),
                "free"
        );
    }

    private List<Apartment> searchFreeApartmentsBySleepingPlaces(CreateRequestDto requestDto) {
        return apartmentRepository.findBySleepingPlacesAndStatusId_NameIgnoreCase(
                requestDto.getApartment().getSleepingPlaces(),
                "free"
        );
    }

    private List<Apartment> searchAnyApartmentsByHotelSleepingPlaces(CreateRequestDto requestDto) {
        return apartmentRepository.findByHotelId_IdAndSleepingPlacesAndStatusId_NameIgnoreCaseNotLike(
                requestDto.getApartment().getHotelId().getId(),
                requestDto.getApartment().getSleepingPlaces(),
                "free"
        );
    }

    @Override
    public List<AdminRequestDto> getAllRequests() {
        log.info("Getting all requests");
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
        log.info("Getting all requests in processing");
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
        log.info("Getting all requests by user id");
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
        log.info("Getting request by id");
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
        log.info("Submitting request edit");
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
        log.info("Applying request");
        Request request = requestRepository.findById(adminRequestDto.getId());
        request.setStatusId(statusRepository.getByNameLikeIgnoreCase("awaiting payment"));
        requestRepository.saveAndFlush(request);
    }

    @Override
    public void payRequest(AdminRequestDto adminRequestDto) {
        log.info("Paying request");
        Request request = requestRepository.findById(adminRequestDto.getId());
        request.setStatusId(statusRepository.getByNameLikeIgnoreCase("paid"));
        request.getApartmentId().setStatusId(statusRepository.getByNameLikeIgnoreCase("occupied"));
        requestRepository.saveAndFlush(request);
    }

    @Override
    public void cancelRequest(AdminRequestDto adminRequestDto) {
        log.info("Cancelling request");
        Request request = requestRepository.findById(adminRequestDto.getId());
        request.setStatusId(statusRepository.getByNameLikeIgnoreCase("cancelled"));
        requestRepository.saveAndFlush(request);
    }

    @Override
    public void completeRequest(Long id) {
        log.info("Completing request");
        Request request = requestRepository.findById(id);
        request.setStatusId(statusRepository.getByNameLikeIgnoreCase("completed"));
        Apartment apartment = apartmentRepository.findById(request.getApartmentId().getId());
        apartment.setStatusId(statusRepository.getByNameLikeIgnoreCase("free"));
    }
}
