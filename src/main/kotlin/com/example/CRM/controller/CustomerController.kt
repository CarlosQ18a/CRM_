package com.example.CRM.controller

import com.example.CRM.dto.CustomerDTO
import com.example.CRM.service.CustomerService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customer")
class CustomerController(private val customerService: CustomerService) {

    @GetMapping
    fun getAllCustomers(): List<CustomerDTO> = customerService.getAllCustomers()

    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable id: Long): CustomerDTO? = customerService.getCustomerById(id)

    @PostMapping
    fun createCustomer(@RequestBody customerDTO: CustomerDTO): CustomerDTO = customerService.createCustomer(customerDTO)

    @PutMapping("/{id}")
    fun updateCustomer(@PathVariable id: Long, @RequestBody customerDTO: CustomerDTO): CustomerDTO? =
        customerService.updateCustomer(id, customerDTO)
}