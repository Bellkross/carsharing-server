package com.bellkross.carsharingserver.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Model(
        @Id
        val name: String = "",
        val brand: String = "",
        val cost: Double = 0.0,
        @Column(name = "waiting_cost")
        val waitingCost: Double = 0.0,
        val type: String = ""
)