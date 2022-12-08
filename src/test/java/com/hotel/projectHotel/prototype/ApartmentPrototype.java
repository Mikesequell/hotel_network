package com.hotel.projectHotel.prototype;

import com.hotel.projectHotel.model.entity.Apartment;

public class ApartmentPrototype {
    public static Apartment getApartments() {
        Apartment apartment = new Apartment();
        apartment.setStatusId(StatusPrototype.getStatus());
        apartment.setHotelId(HotelPrototype.getHotel());
        apartment.setSleepingPlaces(1);
        apartment.setComfortableRank(1);
        apartment.setPrice(10);
        return apartment;
    }
}
