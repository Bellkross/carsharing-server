package com.bellkross.carsharingserver.service

import com.bellkross.carsharingserver.entity.EContract
import com.bellkross.carsharingserver.repository.EContractRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
class EContractService  {

    @Autowired
    private lateinit var repository: EContractRepository

    fun getAll() = repository.findAll()
    fun getById(id: String) = repository.findById(id).get()
    fun save(econtract: EContract) = repository.saveAndFlush(econtract)
    fun delete(econtract: EContract) = repository.delete(econtract)

}