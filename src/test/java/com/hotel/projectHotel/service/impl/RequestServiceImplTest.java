package com.hotel.projectHotel.service.impl;

import com.hotel.projectHotel.dto.AdminRequestDto;
import com.hotel.projectHotel.model.repositiry.ApartmentRepository;
import com.hotel.projectHotel.model.repositiry.RequestRepository;
import com.hotel.projectHotel.model.repositiry.StatusRepository;
import com.hotel.projectHotel.prototype.RequestPrototype;
import com.hotel.projectHotel.service.RequestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RequestServiceImplTest {


    private RequestRepository requestRepository;
    private StatusRepository statusRepository;
    private ApartmentRepository apartmentRepository;
    private RequestService requestService;

    @BeforeEach
    void setUp() {
        requestRepository = mock(RequestRepository.class);
        statusRepository = mock(StatusRepository.class);
        apartmentRepository = mock(ApartmentRepository.class);
        requestService = new RequestServiceImpl(requestRepository, statusRepository, apartmentRepository);
    }

    @Test
    void getAllRequests() {


    }

    @Test
    void getAllRequestsInProcessing() {

    }

    @Test
    void getAllRequestsByUser() {
    }
}