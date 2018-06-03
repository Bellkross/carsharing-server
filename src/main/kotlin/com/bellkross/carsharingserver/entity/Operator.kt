package com.bellkross.carsharingserver.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Operator(
        @Id
        val id: String = "",
        @Column(name = "full_name")
        val fullName: String = "",
        val address: String = "",
        @Column(name = "phone_number")
        val phoneNumber: String = ""
)