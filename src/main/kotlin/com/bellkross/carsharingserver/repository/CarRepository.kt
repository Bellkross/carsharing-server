package com.bellkross.carsharingserver.repository

import com.bellkross.carsharingserver.entity.Car
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CarRepository : JpaRepository<Car, String> {

    @Query(value = "select * from Car;", nativeQuery = true)
    override fun findAll(): MutableList<Car>

    @Query(value = "select * from Car car where car.number = :number",
            nativeQuery = true)
    override fun findById(@Param("number") number: String): Optional<Car>

    /*
    @Query(value = "insert into car (car_number, fuel_card_number, current_address, color, status, creating_date, model_name, insurance_series) " +
            "values (:number, :fuelCardNumber, :address, " +
            ":color, :status, #:creatingYear/:creatingMonth/:creatingDay#, " +
            ":modelName, :series);",
            nativeQuery = true)
    fun save(number: String, fuelCardNumber: String, address: String,
             color: String?, status: Boolean,
             creatingDay: Int, creatingMonth: Int, creatingYear: Int,
             modelName: String, series: String): Car
     */

    /*
    fun delete(obj: Item) = repository().delete(obj)
     */

}