package com.hotel.projectHotel.controller;

import com.hotel.projectHotel.dto.CreateRequestDto;
import com.hotel.projectHotel.dto.HotelDto;
import com.hotel.projectHotel.service.HotelService;
import com.hotel.projectHotel.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;
    private final HotelService hotelService;

    @GetMapping( value = "/showCreateRequest")
    public String showCreateRequest(Model model) {
        model.addAttribute("createRequest", new CreateRequestDto());
        model.addAttribute("hotels", hotelService.getHotelRequestDto());
        return "createNewRequest";
    }

//    @GetMapping("/createRequest")
//    public String createRequestGet(@RequestParam Integer comfortableRank, Model model) {
//
//        return "";
//    }

    @PostMapping(value = "/createRequest")
    public String createRequest(@ModelAttribute(value = "createRequest") CreateRequestDto createRequestDto, Model model) {
        requestService.createNewRequest(createRequestDto);
        List<HotelDto> allHotels = hotelService.getAllHotels();
        model.addAttribute("hotels", allHotels);

        return "listOfHotels";
    }
}
