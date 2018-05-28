package com.bellkross.carsharingserver.repository

import com.bellkross.carsharingserver.entity.Model
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ModelRepository: JpaRepository<Model,String> {
    /*
    find all
    find by id
    save and flush
    delete
     */
}