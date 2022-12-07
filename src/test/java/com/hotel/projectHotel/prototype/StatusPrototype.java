package com.hotel.projectHotel.prototype;


import com.hotel.projectHotel.model.entity.Status;

public class StatusPrototype {

    public static Status getStatus() {
        Status status = new Status();
        status.setName("test_status");
        return status;
    }

}
