package com.hotel.projectHotel.prototype;


import com.hotel.projectHotel.model.entity.Status;

public class StatusPrototype {

    public static Status getTestStatus() {
        Status status = new Status();
        status.setName("test_status");
        return status;
    }
    public static Status getInProcessingStatus() {
        Status status = new Status();
        status.setName("in processing");
        return status;
    }


}
