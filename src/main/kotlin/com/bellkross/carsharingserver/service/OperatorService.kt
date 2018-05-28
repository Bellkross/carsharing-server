package com.bellkross.carsharingserver.service

import com.bellkross.carsharingserver.entity.Operator
import com.bellkross.carsharingserver.repository.OperatorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
class OperatorService {

    @Autowired
    private lateinit var repository: OperatorRepository

    fun getAll() = repository.findAll()
    fun getById(id: String) = repository.findById(id).get()
    fun save(operator: Operator) = repository.saveAndFlush(operator)
    fun delete(operator: Operator) = repository.delete(operator)

}