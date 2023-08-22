package com.sda.rentalloapp.mapper;

import com.sda.rentalloapp.domain.Address;
import com.sda.rentalloapp.dto.AddressDto;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements Mapper<Address, AddressDto> {
    @Override
    public AddressDto fromEntityToDto(Address entity) {
        return AddressDto.builder()
                .id(entity.getId())
                .street(entity.getStreet())
                .zipCode(entity.getZipCode())
                .city(entity.getCity())
                .houseNumber(entity.getHouseNumber())
                .voivodeship(entity.getVoivodeship())
                .country(entity.getCountry())
                .build();
    }

    @Override
    public Address fromDtoToEntity(AddressDto dto) {
        return Address.builder()
                .id(dto.id())
                .street(dto.street())
                .zipCode(dto.zipCode())
                .city(dto.city())
                .houseNumber(dto.houseNumber())
                .voivodeship(dto.voivodeship())
                .country(dto.country())
                .build();
    }
}
