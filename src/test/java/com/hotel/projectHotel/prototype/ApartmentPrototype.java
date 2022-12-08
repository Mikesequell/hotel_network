package com.hotel.projectHotel.prototype;

import com.hotel.projectHotel.model.entity.Apartment;

public class ApartmentPrototype {
    public static Apartment getApartments() {
        Apartment apartment = new Apartment();
//        apartment.setId(10L);
        apartment.setStatusId(StatusPrototype.getTestStatus());
        apartment.setHotelId(HotelPrototype.getHotel());
        apartment.setSleepingPlaces(1);
        apartment.setComfortableRank(1);
        apartment.setPrice(10);
        return apartment;
    }
}
