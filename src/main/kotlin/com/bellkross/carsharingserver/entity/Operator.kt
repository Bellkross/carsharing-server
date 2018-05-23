package com.bellkross.carsharingserver.entity

import javax.persistence.Column

class Operator (
        val id: String,//PK
        @Column(name = "full_name")
        val fullName: String,
        val address: String,
        @Column(name = "phone_number")
        val phoneNumber: String
)