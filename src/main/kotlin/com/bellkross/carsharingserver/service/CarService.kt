package com.bellkross.carsharingserver.service

import com.bellkross.carsharingserver.entity.Car
import com.bellkross.carsharingserver.repository.CarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class CarService {

    @Autowired
    private lateinit var repository: CarRepository

    fun getAll(): MutableList<Car> = repository.findAll()
    fun getById(number: String): Car = repository.findById(number).get()
    fun save(car: Car) = repository.saveAndFlush(car)
    fun delete(car: Car) = repository.delete(car)
    /*fun save(car: Car): Car = repository.save(number = car.number,
            fuelCardNumber = car.fuelCardNumber,
            address = car.address,
            color = car.color,
            status = car.status,
            creatingDay = car.creatingDate.dayOfMonth,
            creatingMonth = car.creatingDate.month.value,
            creatingYear = car.creatingDate.year,
            modelName = car.model.name,
            series = car.insurance.series)*/
}