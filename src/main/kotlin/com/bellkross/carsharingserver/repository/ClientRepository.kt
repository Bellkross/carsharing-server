package com.bellkross.carsharingserver.repository

import com.bellkross.carsharingserver.entity.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository : JpaRepository<Client, String> {
    /*
    find all
    find by id
    save and flush
    delete
     */
}