package com.bellkross.carsharingserver.repository

import com.bellkross.carsharingserver.entity.Insurance
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InsuranceRepository: JpaRepository<Insurance, String> {
    /*
    find all
    find by id
    save and flush
    delete
     */
}