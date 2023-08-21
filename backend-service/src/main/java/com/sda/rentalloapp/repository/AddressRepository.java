package com.sda.rentalloapp.repository;

import com.sda.rentalloapp.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
