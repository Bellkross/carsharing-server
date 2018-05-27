package com.bellkross.carsharingserver.service

import com.bellkross.carsharingserver.entity.Car
import com.bellkross.carsharingserver.repository.CarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Service
class CarService : CarsharingService<Car, String> {

    @Autowired
    private lateinit var repository: CarRepository

    override fun repository(): JpaRepository<Car, String> = repository

}