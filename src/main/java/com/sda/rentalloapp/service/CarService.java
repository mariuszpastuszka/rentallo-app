package com.sda.rentalloapp.service;

import com.sda.rentalloapp.domain.Car;
import com.sda.rentalloapp.exception.WrongCarIdException;
import com.sda.rentalloapp.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CarService {
//    private static final Logger log = LoggerFactory.getLogger(CarService.class);
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        log.info("getting all cars");
//        List<Car> cars = carRepository.findAll();
//        List<Car> someCars = new ArrayList<Car>();
//        var someCars = new ArrayList<Car>();
        var cars = carRepository.findAll();
        log.info("number of cars: [{}]", cars.size());
        log.debug("all cars: {}", cars);
        return cars;
    }

    public Car findCarById(Long carId) {
        return carRepository.findById(carId)
                .map(car -> {
                    log.info("found car: [{}]", car);
                    return car;
                })
                .orElseThrow(() -> new WrongCarIdException("No car with id: " + carId));
    }
}
