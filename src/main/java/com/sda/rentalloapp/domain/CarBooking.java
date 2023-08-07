package com.sda.rentalloapp.domain;

import java.time.LocalDate;

public class CarBooking {

    Car bookedCar;
    Client client;
    LocalDate startDate;
    LocalDate endDate;
    int totalPriceInPolishGrosz;
    Address startLocation;
    Address endLocation;
}
