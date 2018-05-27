package com.bellkross.carsharingserver.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class EContract(
        @Id
        val id: String,
        @Column(name = "start_datetime")
        val startDateTime: LocalDateTime,
        @Column(name = "end_datetime")
        val endDateTime: LocalDateTime,
        @Column(name = "real_datetime")
        val realDateTime: LocalDateTime?,
        @Column(name = "return_address")
        val returnAddress: String?,
        @ManyToOne
        val car: Car,
        @ManyToOne
        val client: Client,
        @ManyToOne
        val operator: Operator
)