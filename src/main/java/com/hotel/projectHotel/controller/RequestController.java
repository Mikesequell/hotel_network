package com.hotel.projectHotel.controller;

import com.hotel.projectHotel.dto.CreateRequestDto;
import com.hotel.projectHotel.dto.HotelDto;
import com.hotel.projectHotel.model.entity.User;
import com.hotel.projectHotel.model.repositiry.UserRepository;
import com.hotel.projectHotel.service.HotelService;
import com.hotel.projectHotel.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;
    private final HotelService hotelService;
    private final UserRepository userRepository;

    @GetMapping(value = "/user/showCreateRequest")
    public String showCreateRequest(Model model) {
        model.addAttribute("createRequest", new CreateRequestDto());
        model.addAttribute("hotels", hotelService.getHotelsRequestDto());
        return "formCreateRequest";
    }

    @PostMapping(value = "/user/createRequest")
    public String createRequest(@ModelAttribute(value = "createRequest") CreateRequestDto createRequestDto, Model model, Principal principal) {
        var user = userRepository.findByUsername(principal.getName());
        createRequestDto.setUserId(user);
        requestService.createRequest(createRequestDto);
        List<HotelDto> allHotels = hotelService.getAllHotels();
        model.addAttribute("hotels", allHotels);

        return "listOfHotels";
    }

    @GetMapping(value = "/admin/showAllRequests")
    public String showAllRequests(Model model) {
        var allRequests = requestService.getAllRequests();
        model.addAttribute("allRequests", allRequests);
        return "adminAllRequests";
    }

    @GetMapping(value = "/admin/showRequestsInProcessing")
    public String showRequestsInProcessing(Model model) {
        var allRequestsInProcessing = requestService.getAllRequestsInProcessing();
        model.addAttribute("allRequestsInProcessing", allRequestsInProcessing);
        return "";
    }

    @GetMapping(value = "/admin/showAllUsers")
    public String showAllUsers(Model model) {

        return "adminShowAllUsers";
    }

    @GetMapping(value = "/admin/showAllRequestsByUser")
    public String showAllRequestsByUser(@RequestParam Long id, Model model) {
        var allRequestsByUserId = requestService.getAllRequestsByUser(id);
        model.addAttribute("allRequestsByUserId", allRequestsByUserId);
        return "";
    }


    @GetMapping(value = "/user/showAllRequestsByUser")
    public String showAllUserRequests() {
        return "";
    }
}
