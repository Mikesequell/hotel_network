package com.hotel.projectHotel.controller;

import com.hotel.projectHotel.dto.AdminRequestDto;
import com.hotel.projectHotel.dto.CreateRequestDto;
import com.hotel.projectHotel.dto.HotelDto;
import com.hotel.projectHotel.model.entity.User;
import com.hotel.projectHotel.model.repositiry.UserRepository;
import com.hotel.projectHotel.service.ApartmentService;
import com.hotel.projectHotel.service.HotelService;
import com.hotel.projectHotel.service.RequestService;
import com.hotel.projectHotel.service.UserService;
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
    private final UserService userService;
    private final ApartmentService apartmentService;

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

    @GetMapping(value = "/user/showAllRequestsByUser")
    public String showAllUserRequests(Model model, Principal principal) {
        var allRequestsByUser = requestService.getAllRequestsByUser(userRepository.findByUsername(principal.getName()).getId());
        model.addAttribute("allRequestsByUser", allRequestsByUser);
        return "userAllRequests";
    }

    @GetMapping(value = "/user/applyRequest")
    public String applyChanges(@RequestParam Long id, Model model, Principal principal) {
        requestService.applyRequest(requestService.getById(id));
        var allRequestsByUser = requestService.getAllRequestsByUser(userRepository.findByUsername(principal.getName()).getId());
        model.addAttribute("allRequestsByUser", allRequestsByUser);
        return "userAllRequests";
    }

    @GetMapping(value = "/user/payRequest")
    public String payRequest(@RequestParam Long id, Model model, Principal principal) {
        requestService.payRequest(requestService.getById(id));
        var allRequestsByUser = requestService.getAllRequestsByUser(userRepository.findByUsername(principal.getName()).getId());
        model.addAttribute("allRequestsByUser", allRequestsByUser);
        return "userAllRequests";
    }

    @GetMapping(value = "/user/cancelRequest")
    public String cancelRequest(@RequestParam Long id, Model model, Principal principal) {
        requestService.cancelRequest(requestService.getById(id));
        var allRequestsByUser = requestService.getAllRequestsByUser(userRepository.findByUsername(principal.getName()).getId());
        model.addAttribute("allRequestsByUser", allRequestsByUser);
        return "userAllRequests";
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
        return "adminAllRequestsInProcessing";
    }

    @GetMapping(value = "/admin/editRequestInProcessing")
    public String editRequestInProcessing(@RequestParam Long id, Model model) {
        var request = requestService.getById(id);
        var freeApartments = apartmentService.getFreeApartmentsByHotelId(request.getApartmentId().getHotelId().getId());
        model.addAttribute("request", request);
        model.addAttribute("freeApartments", freeApartments);
        return "adminEditRequestInProcessing";
    }

    @PostMapping(value = "/admin/editRequestInProcessing")
    public String submitRequestEdit(@ModelAttribute(value = "request") AdminRequestDto adminRequestDto, Model model) {
        requestService.submitRequestEdit(adminRequestDto);
        var allRequests = requestService.getAllRequests();
        model.addAttribute("allRequests", allRequests);
        return "adminAllRequests";
    }

    @GetMapping(value = "/admin/showAllUsers")
    public String showAllUsers(Model model) {
        var users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "adminShowAllUsers";
    }

    @GetMapping(value = "/admin/showAllRequestsByUser")
    public String showAllRequestsByUser(@RequestParam Long id, Model model) {
        var allRequestsByUserId = requestService.getAllRequestsByUser(id);
        model.addAttribute("allRequestsByUserId", allRequestsByUserId);
        return "adminAllRequestsByUserId";
    }

    @GetMapping(value = "/admin/viewRequestById")
    public String viewRequestById(@RequestParam Long id, Model model) {

        return "adminViewRequestById";
    }




}
