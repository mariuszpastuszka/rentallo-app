package com.sda.rentalloapp.repository;

import com.sda.rentalloapp.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
