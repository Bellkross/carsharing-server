package com.bellkross.carsharingserver.entity.dto

import com.bellkross.carsharingserver.entity.Car
import java.time.ZoneId
import java.util.*

data class CarDTO(
        val number: String = "",
        val fuelCardNumber: String = "",
        val address: String = "",
        val color: String? = "",
        val status: Boolean = true,
        val creatingDate: Date = Date(),
        val brand: String = "",
        val price: Double = 0.0
) {
    constructor(car: Car) : this(
            number = car.number,
            fuelCardNumber = car.fuelCardNumber,
            address = car.address,
            color = car.color,
            status = car.status,
            creatingDate = Date.from(car.creatingDate.atStartOfDay(ZoneId.systemDefault()).toInstant()),
            brand = car.model.brand,
            price = car.model.cost
    )
}