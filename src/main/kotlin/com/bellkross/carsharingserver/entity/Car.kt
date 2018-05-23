package com.bellkross.carsharingserver.entity

import java.time.LocalDate
import javax.persistence.Column

class Car(
        val number: String,//PK
        @Column(name = "fuel_card_number")
        val fuelCardNumber: String,
        val address: String,
        val color: String,
        val status: Boolean,
        @Column(name = "creating_date")
        val creatingDate: LocalDate,
        @Column(name = "model_name")
        val modelName: String,//FK
        @Column(name = "car_series")
        val carSeries: String//FK
)