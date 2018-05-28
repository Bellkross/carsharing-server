package com.bellkross.carsharingserver.service

import com.bellkross.carsharingserver.entity.Insurance
import com.bellkross.carsharingserver.repository.InsuranceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
class InsuranceService {

    @Autowired
    private lateinit var repository: InsuranceRepository

    fun getAll() = repository.findAll()
    fun getById(series: String) = repository.findById(series).get()
    fun save(insurance: Insurance) = repository.saveAndFlush(insurance)
    fun delete(insurance: Insurance) = repository.delete(insurance)

}