package com.bellkross.carsharingserver.repository

import com.bellkross.carsharingserver.entity.Car
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarRepository : JpaRepository<Car, String> {

    /*@Query("select ...", nativeQuery = true)*/
    //override fun findAll(): MutableList<Car>

}