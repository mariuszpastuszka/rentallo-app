package com.sda.rentalloapp.dto;

import com.sda.rentalloapp.domain.enumeration.BodyType;
import com.sda.rentalloapp.domain.enumeration.EngineType;
import com.sda.rentalloapp.domain.enumeration.FuelType;
import lombok.Builder;

@Builder
public record CarDto(
        Long id,
        String model,
        String brand,
        FuelType fuelType,
        EngineType engineType,
        BodyType bodyType,
        int numberOfSeats,
        int trunkCapacityInLitres,
        String combustionPer100Km,
        String bodySerialNumber,
        int pricePerDayInPolishGrosz,
        boolean available,
        int rangeInKm,
        PicturesDto pictures
) {
}
