package com.hotel.projectHotel.service;

import com.hotel.projectHotel.dto.AdminRequestDto;
import com.hotel.projectHotel.dto.CreateRequestDto;

import java.util.List;

public interface RequestService {
    void createRequest(CreateRequestDto createRequestDto);

    List<AdminRequestDto> getAllRequests();

    List<AdminRequestDto> getAllRequestsInProcessing();

    List<AdminRequestDto> getAllRequestsByUser(Long id);

    AdminRequestDto getById(Long id);

    void submitRequestEdit(AdminRequestDto adminRequestDto);

    void applyRequest(AdminRequestDto adminRequestDto);
    void payRequest(AdminRequestDto adminRequestDto);
    void cancelRequest(AdminRequestDto adminRequestDto);
}
