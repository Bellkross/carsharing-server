package com.bellkross.carsharingserver.entity

import java.time.LocalDateTime
import javax.persistence.Column

class EContract (
        val id:String,//PK
        @Column(name = "start_datetime")
        val startDateTime: LocalDateTime,
        @Column(name = "end_datetime")
        val endDateTime: LocalDateTime,
        @Column(name = "real_datetime")
        val realDateTime: LocalDateTime,
        @Column(name = "return_address")
        val returnAddress: String,
        @Column(name = "car_number")
        val carNumber: String,//FK
        @Column(name = "licence_number")
        val licenceNumber: String,//FK
        @Column(name = "operator_id")
        val operatorId: String//FK
)