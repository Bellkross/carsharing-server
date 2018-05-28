package com.bellkross.carsharingserver.service

import com.bellkross.carsharingserver.entity.Model
import com.bellkross.carsharingserver.repository.ModelRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ModelService {

    @Autowired
    private lateinit var repository: ModelRepository

    fun getAll() = repository.findAll()
    fun getById(name: String) = repository.findById(name).get()
    fun save(model: Model) = repository.saveAndFlush(model)
    fun delete(model: Model) = repository.delete(model)

}