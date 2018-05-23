package com.bellkross.carsharingserver.entity

import javax.persistence.Column

class Client(
        @Column(name = "licence_number")
        val licenseNumber: String,//PK
        @Column(name = "full_name")
        val fullName: String,
        @Column(name = "credit_card_number")
        val creditCardNumber: String,
        val birthday: String,
        val address: String,
        @Column(name = "registration_date")
        val registrationDate: String,
        @Column(name = "operator_id")
        val operatorId: String,
        @Column(name = "phone_number")
        val phoneNumber: String
)