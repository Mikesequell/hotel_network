package com.hotel.projectHotel.controller;

import com.hotel.projectHotel.model.repositiry.ApartmentRepository;
import com.hotel.projectHotel.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hotel.projectHotel.service.HotelService;


@Controller
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;
    private final ApartmentService apartmentService;

    @GetMapping("/hotel")
    public String getHotel(@RequestParam Integer id, Model model) {
        var apartments = apartmentService.getAllApartmentsByHotelId(id);
        model.addAttribute("apartments", apartments);
        return "listOfApartmentsByHotelId";
    }

    @GetMapping("/hotels")
    public String getAllHotels(Model model) {
        var allHotels = hotelService.getAllHotels();
        model.addAttribute("hotels", allHotels);
        return "listOfHotels";
    }
}
