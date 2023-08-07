package com.sda.rentalloapp.controller;

import com.sda.rentalloapp.dto.CarDto;
import com.sda.rentalloapp.mapper.CarMapper;
import com.sda.rentalloapp.service.CarService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Void> addCar(@RequestBody @Valid CarDto toSave,
                                       UriComponentsBuilder ucb) {
        log.info("adding new car: [{}]", toSave);

        var result = carService.addCar(carMapper.fromDtoToEntity(toSave));
        URI path = ucb.path("/cars/{id}")
//                .buildAndExpand(result.getId())
                .buildAndExpand(Map.of("id", result.getId()))
                .toUri();

        // TODO: homework - cut to only path without server part
        return ResponseEntity.created(path).build();
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable("id") Long carId) {
        log.info("trying to delete car with id: [{}]", carId);
        carService.deleteCarById(carId);
        return ResponseEntity.noContent()
                .build();
    }

    @PutMapping("/cars/{id}")
    public CarDto replaceCar(@RequestBody @Valid CarDto toReplace, @PathVariable("id") Long carId) {
        log.info("trying to replace car by id [{}] with content [{}]", carId, toReplace);
        var entityToReplace = carMapper.fromDtoToEntity(toReplace);
        return carMapper.fromEntityToDto(carService.replaceCar(carId, entityToReplace));
    }

    @PatchMapping("/cars/{id}")
    public CarDto updateCar(@RequestBody @Valid CarDto toReplace, @PathVariable("id") Long carId) {
        return null;
    }
}
