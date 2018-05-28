package com.bellkross.carsharingserver.repository

import com.bellkross.carsharingserver.entity.EContract
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EContractRepository : JpaRepository<EContract, String> {
    /*
    find all
    find by id
    save and flush
    delete
     */
}