package com.sda.rentalloapp.controller;

import com.sda.rentalloapp.domain.Car;
import com.sda.rentalloapp.dto.CarDto;
import com.sda.rentalloapp.mapper.CarMapper;
import com.sda.rentalloapp.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class CarRestController {

    private final CarService carService;
    private final CarMapper carMapper;

    public CarRestController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @GetMapping("/cars")
    public List<CarDto> allCars() {
        log.info("all cars request");

        return carService.getAllCars()
                .stream()
                .map(car -> carMapper.fromEntityToDto(car))
                .toList();
    }
}
