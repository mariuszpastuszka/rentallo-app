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
  // TODO: with explicit FormGroup
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

  value: any;
  get rangeInKm() {
    return this.carForm.controls.rangeInKm
  }
  get available() {
    return this.carForm.controls.available
  }
  get pricePerDayInPolishGrosz() {
    return this.carForm.controls.pricePerDayInPolishGrosz
  }
  get bodySerialNumber() {
    return this.carForm.controls.bodySerialNumber
  }
  get combustionPer100Km() {
    return this.carForm.controls.combustionPer100Km
  }
  get trunkCapacityInLitres() {
    return this.carForm.controls.trunkCapacityInLitres
  }
  get numberOfSeats() {
    return this.carForm.controls.numberOfSeats
  }

  get bodyType() {
    return this.carForm.controls.bodyType
  }
  get engineType() {
    return this.carForm.controls.engineType
  }
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

  sendCar() {
    console.log("data submitted")
    this.value = this.carForm.value
  }
}
