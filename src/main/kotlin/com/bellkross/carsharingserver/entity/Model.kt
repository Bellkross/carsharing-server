package com.bellkross.carsharingserver.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Model(
        @Id
        val name: String,
        val brand: String,
        val cost: Double,
        @Column(name = "waiting_cost")
        val waitingCost: Double,
        val type: String
)