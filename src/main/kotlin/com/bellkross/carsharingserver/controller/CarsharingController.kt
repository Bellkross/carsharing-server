package com.bellkross.carsharingserver.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CarsharingController {

    @GetMapping("/api/test")
    fun getTest() = "Hello world!"

}