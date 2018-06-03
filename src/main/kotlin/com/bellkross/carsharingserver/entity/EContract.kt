package com.bellkross.carsharingserver.entity

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class EContract(
        @Id
        val id: String = "",
        @Column(name = "start_datetime")
        val startDateTime: LocalDateTime = LocalDateTime.now(),
        @Column(name = "end_datetime")
        val endDateTime: LocalDateTime = LocalDateTime.now(),
        @Column(name = "real_datetime")
        val realDateTime: LocalDateTime? = LocalDateTime.now(),
        @Column(name = "return_address")
        val returnAddress: String? = "",
        val type: String = "",
        @ManyToOne
        val car: Car = Car(),
        @ManyToOne
        val client: Client = Client(),
        @ManyToOne
        val operator: Operator = Operator()
)