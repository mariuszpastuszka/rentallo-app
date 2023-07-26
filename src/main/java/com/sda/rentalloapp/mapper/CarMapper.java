package com.sda.rentalloapp.mapper;

import com.sda.rentalloapp.domain.Car;
import com.sda.rentalloapp.domain.Pictures;
import com.sda.rentalloapp.dto.CarDto;
import com.sda.rentalloapp.dto.PicturesDto;
import org.springframework.stereotype.Component;

@Component
public class CarMapper implements Mapper<Car, CarDto> {
    @Override
    public CarDto fromEntityToDto(Car entity) {
        return CarDto.builder()
                .id(entity.getId())
                .model(entity.getModel())
                .brand(entity.getBrand())
                .fuelType(entity.getFuelType())
                .engineType(entity.getEngineType())
                .bodyType(entity.getBodyType())
                .numberOfSeats(entity.getNumberOfSeats())
                .trunkCapacityInLitres(entity.getTrunkCapacityInLitres())
                .combustionPer100Km(entity.getCombustionPer100Km())
                .bodySerialNumber(entity.getBodySerialNumber())
                .pricePerDayInPolishGrosz(entity.getPricePerDayInPolishGrosz())
                .available(entity.isAvailable())
                .rangeInKm(entity.getRangeInKm())
                .pictures(new PicturesDto(entity.getPictures().getMainPictureUrl(), entity.getPictures().getPicturesUrls()))
                .build();
    }

    @Override
    public Car fromDtoToEntity(CarDto dto) {
        return Car.builder()
                .id(dto.id())
                .brand(dto.brand())
                .model(dto.model())
                .fuelType(dto.fuelType())
                .engineType(dto.engineType())
                .bodyType(dto.bodyType())
                .numberOfSeats(dto.numberOfSeats())
                .trunkCapacityInLitres(dto.trunkCapacityInLitres())
                .combustionPer100Km(dto.combustionPer100Km())
                .bodySerialNumber(dto.bodySerialNumber())
                .pricePerDayInPolishGrosz(dto.pricePerDayInPolishGrosz())
                .available(dto.available())
                .rangeInKm(dto.rangeInKm())
                .pictures(new Pictures(dto.pictures().mainPictureUrl(), dto.pictures().picturesUrls()))
                .build();
    }
}
