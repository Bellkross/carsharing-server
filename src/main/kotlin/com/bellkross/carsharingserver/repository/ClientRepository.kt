package com.bellkross.carsharingserver.repository

import com.bellkross.carsharingserver.entity.Car
import com.bellkross.carsharingserver.entity.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository : JpaRepository<Client, String> {

    @Query(value = "SELECT DISTINCT c.*\n" +
            "FROM client c INNER JOIN\n" +
            "econtract ec ON ec.client_licence_number = c.licence_number INNER JOIN\n" +
            "car car ON car.number = ec.car_number\n" +
            "WHERE car.number = :carNumber",
            nativeQuery = true)
    fun findClientsOfCar(@Param("carNumber") carNumber: String) : List<Client>

}