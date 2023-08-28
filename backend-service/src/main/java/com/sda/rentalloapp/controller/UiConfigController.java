package com.sda.rentalloapp.controller;

import com.sda.rentalloapp.domain.enumeration.FuelType;
import com.sda.rentalloapp.dto.ConfigItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/config")
public class UiConfigController {

    @GetMapping("/fuel-types")
    public List<ConfigItem<String, String>> getFuelTypes() {
    // call values on enum
         return Arrays.stream(FuelType.values())
                .map(fuelType ->
                        new ConfigItem<>(fuelType.name(), fuelType.fuelDescription()))
                .toList();
    }
}
