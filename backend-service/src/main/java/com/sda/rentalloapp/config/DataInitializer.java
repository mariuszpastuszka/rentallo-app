package com.sda.rentalloapp.config;


import com.sda.rentalloapp.domain.Address;
import com.sda.rentalloapp.domain.Car;
import com.sda.rentalloapp.domain.Client;
import com.sda.rentalloapp.domain.Pictures;
import com.sda.rentalloapp.domain.enumeration.BodyType;
import com.sda.rentalloapp.domain.enumeration.EngineType;
import com.sda.rentalloapp.domain.enumeration.FuelType;
import com.sda.rentalloapp.repository.AddressRepository;
import com.sda.rentalloapp.repository.CarRepository;
import com.sda.rentalloapp.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Slf4j
@Profile("develop")
public class DataInitializer implements CommandLineRunner {

    private final CarRepository carRepository;

    private final AddressRepository addressRepository;

    private final ClientRepository clientRepository;

    public DataInitializer(CarRepository carRepository, AddressRepository addressRepository, ClientRepository clientRepository) {
        this.carRepository = carRepository;
        this.addressRepository = addressRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public void run(String... args) {
        createCars();
        createClientsWithAddresses();
    }

    private void createClientsWithAddresses() {
        log.info("let's create some locations");

        Address bieszczady = Address.builder()
                .street("Bieszczadzka")
                .zipCode("01-123")
                .houseNumber("11")
                .voivodeship("Podkarpackie")
                .country("Poland")
                .build();
        addressRepository.save(bieszczady);

        log.info("let's create some clients");

        Client first = Client.builder()
                .name("Jan")
                .surname("K.")
                .pesel("80103014444")
                .email("john.k@gmail.com")
                .dateOfBirth(LocalDate.of(1980, 10, 30))
                .phone("111-111-777")
                .address(bieszczady)
                .build();
        Client second = Client.builder()
                .name("Helena")
                .surname("K.")
                .pesel("81103014444")
                .email("helena.k@gmail.com")
                .dateOfBirth(LocalDate.of(1981, 10, 30))
                .phone("111-111-775")
                .address(bieszczady)
                .build();;

        clientRepository.save(first);
        clientRepository.save(second);
    }

    private void createCars() {
        log.info("let's create some cars");
        Car mazda = Car.builder()
                .model("V")
                .brand("mazda")
                .fuelType(FuelType.GAS)
                .engineType(EngineType.V8)
                .bodyType(BodyType.HATCHBACK)
                .numberOfSeats(5)
                .trunkCapacityInLitres(250)
                .combustionPer100Km("5.0/100")
                .bodySerialNumber("1234556")
                .pricePerDayInPolishGrosz(28000)
                .available(true)
                .rangeInKm(800)
                .pictures(new Pictures("https://img.freepik.com/premium-zdjecie/mazda-rx7-na-drodze_917278-30.jpg?w=1060",
                        List.of()))
                .build();

        Car mazda3 = Car.builder()
                .model("III")
                .brand("mazda")
                .fuelType(FuelType.GAS)
                .engineType(EngineType.V8)
                .bodyType(BodyType.HATCHBACK)
                .numberOfSeats(5)
                .trunkCapacityInLitres(250)
                .combustionPer100Km("5.0/100")
                .bodySerialNumber("12345561")
                .pricePerDayInPolishGrosz(18000)
                .available(true)
                .rangeInKm(700)
                .pictures(new Pictures("https://img.freepik.com/premium-zdjecie/mazda-rx7-na-drodze_917278-30.jpg?w=1060",
                        List.of()))
                .build();

        carRepository.save(mazda);
        carRepository.save(mazda3);
    }
}
