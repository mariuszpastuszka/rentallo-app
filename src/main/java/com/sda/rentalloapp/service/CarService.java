package com.sda.rentalloapp.service;

import com.sda.rentalloapp.domain.Car;
import com.sda.rentalloapp.exception.WrongCarIdException;
import com.sda.rentalloapp.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Car addCar(Car car) {
        Car saved = carRepository.save(car);
        log.info("saved car: [{}]", saved);
        return saved;
    }

    @Transactional
    public void deleteCarById(Long carId) {
        log.info("delete car by id: [{}]", carId);
        boolean exist = carRepository.existsById(carId);
        if (exist) {
            carRepository.deleteById(carId);
        } else {
            throw new WrongCarIdException("Wrong id: " + carId);
        }
    }

    @Transactional
    public Car replaceCar(Long carId, Car entityToReplace) {
        log.info("replacing car with id [{}] with content [{}]", carId, entityToReplace);
        boolean exist = carRepository.existsById(carId);

        if (!exist) {
            throw new WrongCarIdException("Wrong car id: " + carId);
        }

        if (!carId.equals(entityToReplace.getId())) {
//            throw new WrongCarIdException(String.format("Ids mismatch: [%d] vs [%d]", carId, entityToReplace.getId()));
            throw new WrongCarIdException("Ids mismatch: [%d] vs [%d]".formatted(carId, entityToReplace.getId()));
        }
        return carRepository.save(entityToReplace);
    }
}
