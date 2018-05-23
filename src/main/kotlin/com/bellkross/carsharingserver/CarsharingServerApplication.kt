package com.bellkross.carsharingserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CarsharingServerApplication

fun main(args: Array<String>) {
    runApplication<CarsharingServerApplication>(*args)
}
