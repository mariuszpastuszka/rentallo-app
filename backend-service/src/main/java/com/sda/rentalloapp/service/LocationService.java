package com.sda.rentalloapp.service;

import com.sda.rentalloapp.domain.Address;
import com.sda.rentalloapp.exception.WrongAddressIdException;
import com.sda.rentalloapp.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LocationService {

    private final AddressRepository addressRepository;

    public LocationService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address findAddressById(Long addressId) {
        return addressRepository.findById(addressId)
                .map(address -> {
                    log.info("Found location: [{}]", address);
                    return address;
                })
                .orElseThrow(() -> new WrongAddressIdException("No address with given id [%d]".formatted(addressId)));
    }
}
