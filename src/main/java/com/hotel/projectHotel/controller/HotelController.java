package com.hotel.projectHotel.controller;

import com.hotel.projectHotel.model.entity.Apartment;
import com.hotel.projectHotel.model.entity.Hotel;
import com.hotel.projectHotel.model.repositiry.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hotel.projectHotel.service.HotelService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;
    private final ApartmentRepository apartmentRepository;

    @GetMapping("/hotel")
    public String getHotel(@RequestParam Integer id, Model model) {
        var apartments = apartmentRepository.findByHotel_Id(id);
        model.addAttribute("apartments", apartments);
        return "listOfApartmentByHotelId";
    }

    @GetMapping("/hotels")
    public String getAllHotels(Model model) {
        var allHotels = hotelService.findAll();
        model.addAttribute("hotels", allHotels);
        return "listOfHotels";
    }
}
