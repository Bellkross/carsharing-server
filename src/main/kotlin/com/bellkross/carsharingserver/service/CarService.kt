package com.bellkross.carsharingserver.service

import com.bellkross.carsharingserver.entity.Car
import com.bellkross.carsharingserver.repository.CarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CarService {

    @Autowired
    private lateinit var repository: CarRepository

    fun getAll(): MutableList<Car> = repository.findAll()
    fun getById(number: String): Car = repository.findById(number).get()
    fun delete(car: Car) = repository.delete(car)
    fun save(car: Car) = repository.save(car)

    fun getCarsByAddress(address: String): List<Car> = repository.findCarsByAddress(address)

    fun getCarsByModel(modelName: String): List<Car> = repository.findCarsByModel(modelName)

    fun getCarsByInsurance(insuranceSeries: String): List<Car> = repository.findCarsByInsurance(insuranceSeries)

    fun getCarsByColor(color: String): List<Car> = repository.findCarsByColor(color)

    fun getCarsOfClient(licenceNumber: String): List<Car> = repository.findCarsOfClient(licenceNumber)

}
