package com.sda.rentalloapp.controller;

import com.sda.rentalloapp.domain.CarBooking;
import com.sda.rentalloapp.dto.CarBookingDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class CarBookingController {

    @PostMapping("/car-bookings")
    public CarBookingDto bookCar(@RequestBody CarBookingDto bookingDto) {
        return null;
    }
}
