package com.bellkross.carsharingserver.controller

import com.bellkross.carsharingserver.service.CarService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CarsharingController {

    @Autowired
    lateinit var carService: CarService

    @GetMapping("/api/test")
    fun getTest() = "Hello world!"

    @GetMapping("/api/getAllCars")
    fun getAllCars() = carService.getAll()

}