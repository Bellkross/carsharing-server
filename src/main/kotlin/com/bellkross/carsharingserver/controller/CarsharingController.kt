package com.bellkross.carsharingserver.controller

import com.bellkross.carsharingserver.entity.*
import com.bellkross.carsharingserver.service.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class CarsharingController {

    @Autowired
    lateinit var carService: CarService

    @Autowired
    lateinit var clientService: ClientService

    @Autowired
    lateinit var modelService: ModelService

    @Autowired
    lateinit var insuranceService: InsuranceService

    @Autowired
    lateinit var contractService: EContractService

    @Autowired
    lateinit var operatorService: OperatorService

    @GetMapping("/api/test")
    fun getTest() = "Hello world!"

    /** CARS */
    @GetMapping("/api/cars/getAllCars")
    fun getAllCars() = carService.getAll()

    @GetMapping("/api/cars/car_number={number}")
    fun getCar(@PathVariable("number") number: String) = carService.getById(number)

    @PostMapping("/api/cars")
    fun postCar(@Valid @RequestBody car: Car): Car = carService.save(car)

    @PutMapping("/api/cars")
    fun putCar(@Valid @RequestBody car: Car): Car = carService.save(car)

    @DeleteMapping("/api/cars/car_number={number}")
    fun deleteCar(@PathVariable("number") number: String) = carService.delete(carService.getById(number))

    /** CLIENTS */

    @GetMapping("/api/clients/getAllClients")
    fun getAllClients() = clientService.getAll()

    @GetMapping("/api/clients/licenceNumber={number}")
    fun getClient(@PathVariable("number") number: String) = clientService.getById(number)

    @PostMapping("/api/clients")
    fun postClient(@Valid @RequestBody client: Client): Client = clientService.save(client)

    @PutMapping("/api/clients")
    fun putClient(@Valid @RequestBody client: Client): Client = clientService.save(client)

    @DeleteMapping("/api/clients/licenceNumber={number}")
    fun deleteClient(@PathVariable("number") number: String) = clientService.delete(clientService.getById(number))


    /** MODELS */

    @GetMapping("/api/models/getAllModels")
    fun getAllModels(): MutableList<Model> = modelService.getAll()

    @GetMapping("/api/models/model_name={name}")
    fun getModel(@PathVariable("name") name: String) = modelService.getById(name)

    @PostMapping("/api/models")
    fun postModel(@Valid @RequestBody model: Model): Model = modelService.save(model)

    @PutMapping("/api/models")
    fun putModel(@Valid @RequestBody model: Model): Model = modelService.save(model)

    @DeleteMapping("/api/models/model_name={name}")
    fun deleteModel(@PathVariable("name") name: String) = modelService.delete(modelService.getById(name))

    /** INSURANCES */

    @GetMapping("/api/insurances/getAllInsurances")
    fun getAllInsurances(): MutableList<Insurance> = insuranceService.getAll()

    @GetMapping("/api/insurances/insurance_series={series}")
    fun getInsurance(@PathVariable("series") series: String) = insuranceService.getById(series)

    @PostMapping("/api/insurances")
    fun postInsurance(@Valid @RequestBody insurance: Insurance): Insurance = insuranceService.save(insurance)

    @PutMapping("/api/insurances")
    fun putInsurance(@Valid @RequestBody insurance: Insurance): Insurance = insuranceService.save(insurance)

    @DeleteMapping("/api/insurances/insurance_series={series}")
    fun deleteInsurance(@PathVariable("series") series: String) = insuranceService.delete(insuranceService.getById(series))

    /** ECONTRACTS */

    @GetMapping("/api/contracts/getAllContracts")
    fun getAllContracts(): MutableList<EContract> = contractService.getAll()

    @GetMapping("/api/contracts/contract_id={id}")
    fun getContract(@PathVariable("id") id: String): EContract = contractService.getById(id)

    @PostMapping("/api/contracts")
    fun postContract(@Valid @RequestBody contract: EContract): EContract = contractService.save(contract)

    @PutMapping("/api/contracts")
    fun putContract(@Valid @RequestBody contract: EContract): EContract = contractService.save(contract)

    @DeleteMapping("/api/contracts/contract_id={id}")
    fun deleteContract(@PathVariable("id") id: String) = contractService.delete(contractService.getById(id))

    /** OPERATORS */

    @GetMapping("/api/operators/getAllOperators")
    fun getAllOperators():MutableList<Operator> = operatorService.getAll()
    @GetMapping("/api/operators/operator_id={id}")
    fun getOperator(@PathVariable("id") id: String): Operator = operatorService.getById(id)
    @PostMapping("/api/operators")
    fun postOperator(@Valid @RequestBody operator: Operator): Operator = operatorService.save(operator)
    @PutMapping("/api/operators")
    fun putOperator(@Valid @RequestBody operator: Operator): Operator = operatorService.save(operator)
    @DeleteMapping("/api/operators/operator_id={id}")
    fun deleteOperator(@PathVariable("id") id: String) = operatorService.delete(operatorService.getById(id))
}