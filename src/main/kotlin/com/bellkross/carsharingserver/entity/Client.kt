package com.bellkross.carsharingserver.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Client(
        @Id
        @Column(name = "licence_number")
        val licenseNumber: String = "",
        @Column(name = "full_name")
        val fullName: String = "",
        @Column(name = "credit_card_number")
        val creditCardNumber: String = "",
        val birthday: String = "",
        val address: String = "",
        @Column(name = "registration_date")
        val registrationDate: String = "",
        @Column(name = "phone_number")
        val phoneNumber: String = "",
        @Column(name = "password")
        val password: String = ""
)