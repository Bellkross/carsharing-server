package com.bellkross.carsharingserver.repository

import com.bellkross.carsharingserver.entity.Car
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CarRepository : JpaRepository<Car, String> {

    @Query(value = "SELECT * FROM Car;", nativeQuery = true)
    override fun findAll(): MutableList<Car>

    @Query(value = "SELECT * FROM Car car " +
            "WHERE car.number = :number",
            nativeQuery = true)
    override fun findById(@Param("number") number: String): Optional<Car>

    @Query(value = "SELECT * FROM Car car " +
            "WHERE car.address = :address",
            nativeQuery = true)
    fun findCarsByAddress(@Param("address") address: String): List<Car>

    @Query(value = "SELECT * FROM Car car " +
            "WHERE car.model_name = :modelName",
            nativeQuery = true)
    fun findCarsByModel(@Param("modelName") modelName: String): List<Car>

    @Query(value = "SELECT * FROM Car car " +
            "WHERE car.insurance_series = :insuranceSeries",
            nativeQuery = true)
    fun findCarsByInsurance(@Param("insuranceSeries") insuranceSeries: String): List<Car>

    @Query(value = "SELECT * FROM Car car " +
            "WHERE car.color = :color",
            nativeQuery = true)
    fun findCarsByColor(@Param("color") color: String): List<Car>

    @Query(value = "SELECT DISTINCT car.* " +
            "FROM car car INNER JOIN " +
            "econtract ec ON car.number = ec.car_number INNER JOIN " +
            "client c ON ec.client_licence_number = c.licence_number " +
            "WHERE c.licence_number = :licenceNumber",
            nativeQuery = true)
    fun findCarsOfClient(@Param("licenceNumber") licenceNumber: String): List<Car>

    @Query(value = "SELECT car.* " +
            "FROM car car " +
            "WHERE car.status = true",
            nativeQuery = true)
    fun findCarsForClient(): List<Car>

}