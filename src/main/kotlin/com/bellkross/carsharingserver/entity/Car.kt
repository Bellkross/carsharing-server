package com.bellkross.carsharingserver.entity

import java.time.LocalDate
import javax.persistence.*

@Entity
class Car(
        @Id
        val number: String,
        @Column(name = "fuel_card_number")
        val fuelCardNumber: String,
        val address: String,
        val color: String?,
        val status: Boolean,
        @Column(name = "creating_date")
        val creatingDate: LocalDate,
        @ManyToOne
//        @JoinColumn(name = "model_name")
        val model: Model,//model_name
        @OneToOne
//        @JoinColumn(name = "series")
        val insurance: Insurance//car_series
)