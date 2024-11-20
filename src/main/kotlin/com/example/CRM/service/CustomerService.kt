package com.example.CRM.service

import com.example.CRM.dto.CustomerDTO
import com.example.CRM.model.Customer
import com.example.CRM.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository) {

    fun getAllCustomers(): List<CustomerDTO> =
        customerRepository.findAll().map { customer ->
            CustomerDTO(customer.id, customer.name)
        }

    fun getCustomerById(id: Long): CustomerDTO? =
        customerRepository.findById(id).map { customer ->
            CustomerDTO(customer.id, customer.name)
        }.orElse(null)

    fun createCustomer(customerDTO: CustomerDTO): CustomerDTO {
        val customer = Customer(name = customerDTO.name)
        val savedCustomer = customerRepository.save(customer)
        return CustomerDTO(savedCustomer.id, savedCustomer.name)
    }

    fun updateCustomer(id: Long, customerDTO: CustomerDTO): CustomerDTO? {
        return if (customerRepository.existsById(id)) {
            val customer = Customer(id = id, name = customerDTO.name)
            val updatedCustomer = customerRepository.save(customer)
            CustomerDTO(updatedCustomer.id, updatedCustomer.name)
        } else {
            null
        }
    }
}