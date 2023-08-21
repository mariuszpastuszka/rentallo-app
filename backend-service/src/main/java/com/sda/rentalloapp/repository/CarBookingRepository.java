package com.sda.rentalloapp.repository;

import com.sda.rentalloapp.domain.CarBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarBookingRepository extends JpaRepository<CarBooking, Long> {
}
