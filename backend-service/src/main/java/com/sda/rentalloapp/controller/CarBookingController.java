package com.sda.rentalloapp.controller;

import com.sda.rentalloapp.dto.CarBookingDto;
import com.sda.rentalloapp.dto.CarBookingRequestDto;
import com.sda.rentalloapp.service.CarBookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class CarBookingController {

    private final CarBookingService bookingService;

    public CarBookingController(CarBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/car-bookings")
    public CarBookingDto bookCar(@RequestBody CarBookingRequestDto bookingDto) {
        log.info("Car booking request: [{}]", bookingDto);
        bookingService.bookCar(bookingDto);

        throw new RuntimeException("Not finished");
    }
}
