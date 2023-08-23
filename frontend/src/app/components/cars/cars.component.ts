import {Component, OnInit} from '@angular/core';
import {CarService} from "../../services/car/car.service";
import {Car} from "../../models/car";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-cars',
  templateUrl: './cars.component.html',
  styleUrls: ['./cars.component.css']
})
export class CarsComponent implements OnInit {

  cars: Array<Car> = []
  carForm = new FormGroup({
    model: new FormControl(''),
    brand: new FormControl(''),
    fuelType: new FormControl(''),
    engineType: new FormControl(''),
    bodyType: new FormControl(''),
    numberOfSeats: new FormControl(4),
    trunkCapacityInLitres: new FormControl(200),
    combustionPer100Km: new FormControl(''),
    bodySerialNumber: new FormControl(''),
    pricePerDayInPolishGrosz: new FormControl(0),
    available: new FormControl(true),
    rangeInKm: new FormControl(300),
    pictures: new FormGroup({
      mainPictureUrl: new FormControl(''),
      picturesUrls: new FormControl(Array<string>)
    })
  })
  get fuelType() {
    return this.carForm.controls.fuelType
  }

  get model() {
    return this.carForm.controls.model
  }

  get brand() {
    return this.carForm.controls.brand
  }
  constructor(private carService: CarService) {
  }

  ngOnInit(): void {
    this.carService
      .getCars()
      .subscribe(carsFromServer => {
        console.log("data from server: " + JSON.stringify(carsFromServer, null, 2))
        this.cars = carsFromServer
      })
  }
}
