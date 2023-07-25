package com.sda.rentalloapp.mapper;

import com.sda.rentalloapp.domain.Car;
import com.sda.rentalloapp.dto.CarDto;
import org.springframework.stereotype.Component;

@Component
public class CarMapper implements Mapper<Car, CarDto> {
    @Override
    public CarDto fromEntityToDto(Car entity) {
        return null;
    }

    @Override
    public Car fromDtoToEntity(CarDto dto) {
        return null;
    }
}
