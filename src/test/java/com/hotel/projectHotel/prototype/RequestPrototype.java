package com.hotel.projectHotel.prototype;

import com.hotel.projectHotel.dto.AdminRequestDto;
import com.hotel.projectHotel.model.entity.Request;

import java.sql.Date;


public class RequestPrototype {

    public static Request getRequest() {
        Request request = new Request();
        request.setArrivalDate(new Date(new java.util.Date().getTime()));
        request.setDepartureDate(new Date(new java.util.Date().getTime()));
        request.setUserId(UsersPrototype.getUser());
        request.setApartmentId(ApartmentPrototype.getApartments());
        request.setStatusId(StatusPrototype.getTestStatus());
        request.setOfferedPriceForPayment(100);
        return request;
    }

    public static Request getRequestInProcessing() {
        Request request = new Request();
        request.setArrivalDate(new Date(new java.util.Date().getTime()));
        request.setDepartureDate(new Date(new java.util.Date().getTime()));
        request.setUserId(UsersPrototype.getUser());
        request.setApartmentId(ApartmentPrototype.getApartments());
        request.setStatusId(StatusPrototype.getInProcessingStatus());
        request.setOfferedPriceForPayment(100);
        return request;
    }

    public static AdminRequestDto getAdminRequestDto() {
        AdminRequestDto adminRequestDto = new AdminRequestDto();
        adminRequestDto.setArrivalDate(new Date(new java.util.Date().getTime()));
        adminRequestDto.setDepartureDate(new Date(new java.util.Date().getTime()));
        adminRequestDto.setUserId(UsersPrototype.getUser());
        adminRequestDto.setApartmentId(ApartmentPrototype.getApartments());
        adminRequestDto.setStatusId(StatusPrototype.getTestStatus());
        adminRequestDto.setOfferedPriceForPayment(100);
        return adminRequestDto;
    }

    public static AdminRequestDto getAdminRequestDtoInProcessing() {
        AdminRequestDto adminRequestDto = new AdminRequestDto();
        adminRequestDto.setArrivalDate(new Date(new java.util.Date().getTime()));
        adminRequestDto.setDepartureDate(new Date(new java.util.Date().getTime()));
        adminRequestDto.setUserId(UsersPrototype.getUser());
        adminRequestDto.setApartmentId(ApartmentPrototype.getApartments());
        adminRequestDto.setStatusId(StatusPrototype.getInProcessingStatus());
        adminRequestDto.setOfferedPriceForPayment(100);
        return adminRequestDto;
    }
}
