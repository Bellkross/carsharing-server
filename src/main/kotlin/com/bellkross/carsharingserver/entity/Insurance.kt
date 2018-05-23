package com.bellkross.carsharingserver.entity

import java.time.LocalDate
import javax.persistence.Column

class Insurance(
        val series: String,//PK
        @Column(name = "creating_date")
        val creatingDate: LocalDate,
        @Column(name = "ending_date")
        val endingDate: LocalDate,
        val address: String,
        @Column(name = "identification_number")
        val identificationNumber: String,
        @Column(name = "company_name")
        val companyName: String
)