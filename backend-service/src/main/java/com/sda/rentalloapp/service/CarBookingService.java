package com.sda.rentalloapp.service;

import com.sda.rentalloapp.domain.Car;
import com.sda.rentalloapp.domain.CarBooking;
import com.sda.rentalloapp.domain.Client;
import com.sda.rentalloapp.dto.CarBookingRequestDto;
import com.sda.rentalloapp.repository.CarBookingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class CarBookingService {

    private final CarBookingRepository carBookingRepository;
    private final CarService carService;
    private final ClientService clientService;

    public CarBookingService(CarBookingRepository carBookingRepository, CarService carService, ClientService clientService) {
        this.carBookingRepository = carBookingRepository;
        this.carService = carService;
        this.clientService = clientService;
    }


    @Transactional
    public CarBooking bookCar(CarBookingRequestDto bookingDto) {
        log.info("Booking car with request: [{}]", bookingDto);
        Car car = carService.findCarById(bookingDto.bookedCarId());
        Client client = clientService.findClientById(bookingDto.clientId());
        return null;
    }
}
