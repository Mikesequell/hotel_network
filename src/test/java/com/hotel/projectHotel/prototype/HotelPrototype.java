package com.hotel.projectHotel.prototype;

import com.hotel.projectHotel.model.entity.Hotel;

public class HotelPrototype {
    public static Hotel getHotel() {
        Hotel hotel = new Hotel();
        hotel.setAddress("test address");
        hotel.setName("test_name");
        return hotel;
    }
}
