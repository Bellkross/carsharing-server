package com.bellkross.carsharingserver.controller

import com.bellkross.carsharingserver.entity.Car
import com.bellkross.carsharingserver.service.CarService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class CarsharingController {

    @Autowired
    lateinit var carService: CarService

    @GetMapping("/api/test")
    fun getTest() = "Hello world!"

    /** CARS */
    @GetMapping("/api/cars/getAllCars")
    fun getAllCars() = carService.getAll()

    @GetMapping("/api/cars/car_number={number}")
    fun getCar(@PathVariable("number") number: String) = carService.getById(number)

    @PostMapping("/api/cars")
    fun postCar(@Valid @RequestBody car: Car): Car = carService.save(car)

    @PutMapping("/api/cars")
    fun putCar(@Valid @RequestBody car: Car) : Car = carService.save(car)

    @DeleteMapping("/api/cars/number={number}")
    fun deleteCar(@PathVariable("number") number: String) = carService.delete(carService.getById(number))

}