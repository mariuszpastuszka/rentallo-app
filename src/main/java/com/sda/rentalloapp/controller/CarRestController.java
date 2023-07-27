package com.sda.rentalloapp.controller;

import com.sda.rentalloapp.dto.CarDto;
import com.sda.rentalloapp.mapper.CarMapper;
import com.sda.rentalloapp.service.CarService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @GetMapping("/cars/{id}")
    public CarDto getCarById(@PathVariable("id") Long carId) {
        log.info("trying to find car with id: [{}]", carId);
        return carMapper.fromEntityToDto(carService.findCarById(carId));
    }

    @PostMapping("/cars")
    public ResponseEntity<Void> addCar(@RequestBody @Valid CarDto toSave) {
        log.info("adding new car: [{}]", toSave);

        var result = carService.addCar(carMapper.fromDtoToEntity(toSave));
        URI uri = URI.create("/api/cars/" + result.getId());
        return ResponseEntity.created(uri).build();
    }
}
