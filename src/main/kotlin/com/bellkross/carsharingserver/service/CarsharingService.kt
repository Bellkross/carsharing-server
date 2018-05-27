package com.bellkross.carsharingserver.service

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CarsharingService<Item, Id> {
    fun repository(): JpaRepository<Item, Id>
    fun getAll(): List<Item> = repository().findAll()
    fun getById(id: Id): Item = repository().findById(id).get()
    fun save(obj: Item) = repository().saveAndFlush(obj)
    fun delete(obj: Item) = repository().delete(obj)
}