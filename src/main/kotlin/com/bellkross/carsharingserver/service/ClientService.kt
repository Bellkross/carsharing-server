package com.bellkross.carsharingserver.service

import com.bellkross.carsharingserver.entity.Client
import com.bellkross.carsharingserver.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
class ClientService {

    @Autowired
    private lateinit var repository: ClientRepository

    fun getAll(): MutableList<Client> = repository.findAll()
    fun getById(licenseNumber: String): Client = repository.findById(licenseNumber).get()
    fun save(client: Client) : Client = repository.saveAndFlush(client)
    fun delete(client: Client) = repository.delete(client)
}