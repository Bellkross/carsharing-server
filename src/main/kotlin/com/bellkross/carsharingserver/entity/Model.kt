package com.bellkross.carsharingserver.entity

import javax.persistence.Column

class Model(
        val name: String,//PK
        val brand: String,
        val cost: Double,
        @Column(name = "waiting_cost")
        val waitingCost: Double,
        val type: String
)