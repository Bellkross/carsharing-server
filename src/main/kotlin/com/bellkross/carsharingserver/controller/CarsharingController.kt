package com.bellkross.carsharingserver.controller

import com.bellkross.carsharingserver.entity.*
import com.bellkross.carsharingserver.service.*
import org.apache.commons.codec.digest.DigestUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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

    //ADMINISTRATOR PART////////////////////////////////////////////////////////////////////////////////////////////////

    /** CARS */
    @GetMapping("/api/cars/getAllCars")
    fun getAllCars() = ResponseEntity.ok(carService.getAll()
    )

    @GetMapping("/api/cars/car_number={number}")
    fun getCar(@PathVariable("number") number: String) = ResponseEntity.ok(carService.getById(number))

    @PostMapping("/api/cars")
    fun postCar(@Valid @RequestBody car: Car) = ResponseEntity.ok(carService.save(car))

    @PutMapping("/api/cars")
    fun putCar(@Valid @RequestBody car: Car) = ResponseEntity.ok(carService.save(car))

    @DeleteMapping("/api/cars/car_number={number}")
    fun deleteCar(@PathVariable("number") number: String) = ResponseEntity.ok(carService.delete(carService.getById(number)))

    @GetMapping("/api/cars/address={address}")
    fun getCarsByAddress(@PathVariable(value = "address") address: String) = ResponseEntity.ok(carService.getCarsByAddress(address))

    @GetMapping("/api/cars/model_name={model_name}")
    fun getCarsByModel(@PathVariable(value = "model_name") modelName: String) = ResponseEntity.ok(carService.getCarsByModel(modelName))

    @GetMapping("/api/cars/series={series}")
    fun getCarsByInsurance(@PathVariable(value = "series") series: String) = ResponseEntity.ok(carService.getCarsByInsurance(series))

    @GetMapping("/api/cars/color={color}")
    fun getCarsByColor(@PathVariable(value = "color") color: String) = ResponseEntity.ok(carService.getCarsByColor(color))

    @GetMapping("/api/cars/licenceNumber={licence_number}")
    fun getCarsOfClient(@PathVariable(value = "licence_number") licenceNumber: String) = ResponseEntity.ok(carService.getCarsOfClient(licenceNumber))

    /** CLIENTS */

    @GetMapping("/api/clients/getAllClients")
    fun getAllClients() = ResponseEntity.ok(clientService.getAll()
    )

    @GetMapping("/api/clients/licenceNumber={number}")
    fun getClient(@PathVariable("number") number: String) = ResponseEntity.ok(clientService.getById(number).get())

    @GetMapping("/api/clients/car_number={car_number}")
    fun getClientsOfCar(@PathVariable("car_number") carNumber: String) = ResponseEntity.ok(clientService.getClientsOfCar(carNumber))

    @PostMapping("/api/clients")
    fun postClient(@Valid @RequestBody client: Client) = ResponseEntity.ok(clientService.save(client))

    @PutMapping("/api/clients")
    fun putClient(@Valid @RequestBody client: Client) = ResponseEntity.ok(clientService.save(client))

    @DeleteMapping("/api/clients/licenceNumber={number}")
    fun deleteClient(@PathVariable("number") number: String) = clientService.delete(clientService.getById(number).get())


    /** MODELS */

    @GetMapping("/api/models/getAllModels")
    fun getAllModels() = ResponseEntity.ok(modelService.getAll()
    )

    @GetMapping("/api/models/model_name={name}")
    fun getModel(@PathVariable("name") name: String) = ResponseEntity.ok(modelService.getById(name))

    @PostMapping("/api/models")
    fun postModel(@Valid @RequestBody model: Model) = ResponseEntity.ok(modelService.save(model))

    @PutMapping("/api/models")
    fun putModel(@Valid @RequestBody model: Model) = ResponseEntity.ok(modelService.save(model))

    @DeleteMapping("/api/models/model_name={name}")
    fun deleteModel(@PathVariable("name") name: String) = modelService.delete(modelService.getById(name))

    /** INSURANCES */

    @GetMapping("/api/insurances/getAllInsurances")
    fun getAllInsurances() = ResponseEntity.ok(insuranceService.getAll()
    )

    @GetMapping("/api/insurances/insurance_series={series}")
    fun getInsurance(@PathVariable("series") series: String) = ResponseEntity.ok(insuranceService.getById(series))

    @PostMapping("/api/insurances")
    fun postInsurance(@Valid @RequestBody insurance: Insurance) = ResponseEntity.ok(insuranceService.save(insurance))

    @PutMapping("/api/insurances")
    fun putInsurance(@Valid @RequestBody insurance: Insurance) = ResponseEntity.ok(insuranceService.save(insurance))

    @DeleteMapping("/api/insurances/insurance_series={series}")
    fun deleteInsurance(@PathVariable("series") series: String) = insuranceService.delete(insuranceService.getById(series))

    /** ECONTRACTS */

    @GetMapping("/api/contracts/getAllContracts")
    fun getAllContracts() = ResponseEntity.ok(contractService.getAll()
    )

    @GetMapping("/api/contracts/contract_id={id}")
    fun getContract(@PathVariable("id") id: String) = ResponseEntity.ok(contractService.getById(id))

    @PostMapping("/api/contracts")
    fun postContract(@Valid @RequestBody contract: EContract) = ResponseEntity.ok(contractService.save(contract))

    @PutMapping("/api/contracts")
    fun putContract(@Valid @RequestBody contract: EContract) = ResponseEntity.ok(contractService.save(contract))

    @DeleteMapping("/api/contracts/contract_id={id}")
    fun deleteContract(@PathVariable("id") id: String) = contractService.delete(contractService.getById(id))

    /** OPERATORS */

    @GetMapping("/api/operators/getAllOperators")
    fun getAllOperators() = ResponseEntity.ok(operatorService.getAll()
    )

    @GetMapping("/api/operators/operator_id={id}")
    fun getOperator(@PathVariable("id") id: String) = ResponseEntity.ok(operatorService.getById(id))

    @PostMapping("/api/operators")
    fun postOperator(@Valid @RequestBody operator: Operator) = ResponseEntity.ok(operatorService.save(operator))

    @PutMapping("/api/operators")
    fun putOperator(@Valid @RequestBody operator: Operator) = ResponseEntity.ok(operatorService.save(operator))

    @DeleteMapping("/api/operators/operator_id={id}")
    fun deleteOperator(@PathVariable("id") id: String) = operatorService.delete(operatorService.getById(id))

    //USER PART/////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
     MD5 hex of word password -> 286755fad04869ca523320acce0dc6a4
     */
    @GetMapping("/api/clients/authorization")
    fun authorization(@RequestHeader("Authorization") authorization: String): ResponseEntity<Boolean> {
        val params: Map<String, String> = getAuthorizationParams(authorization)
        val clientOptional = clientService.getById(params["licenceNumber"].toString())

        return if (clientOptional.isPresent)
            ResponseEntity.ok(DigestUtils.md5Hex(clientOptional.get().password) ==
                    params["password"].toString())
        else
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(false)
    }

    private fun getAuthorizationParams(authorization: String): Map<String, String> {
        val result: HashMap<String, String> = HashMap()
        val licenceNumberPart = authorization.split(", ")[0].split("=")
        val passwordPart = authorization.split(", ")[1].split("=")
        result[licenceNumberPart[0]] = licenceNumberPart[1]
        result[passwordPart[0]] = passwordPart[1]
        return result
    }

}