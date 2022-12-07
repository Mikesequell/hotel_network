package com.hotel.projectHotel.prototype;

import com.hotel.projectHotel.model.entity.Request;

public class RequestPrototype {

    public static Request getRequest() {
        Request request = new Request();
        request.setId(3L);
        request.setStatusId(StatusPrototype.getStatus());
        return request;
    }
}
