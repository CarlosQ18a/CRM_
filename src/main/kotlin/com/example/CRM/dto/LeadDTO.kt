
package com.example.CRM.dto

data class LeadDTO(
    val id: Long,
    val customerId: Long,
    val source: String,
    val status: String
)

