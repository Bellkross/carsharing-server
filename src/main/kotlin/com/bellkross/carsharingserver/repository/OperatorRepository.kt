package com.bellkross.carsharingserver.repository

import com.bellkross.carsharingserver.entity.Operator
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OperatorRepository: JpaRepository<Operator,String> {
    /*
    find all
    find by id
    save and flush
    delete
     */
}