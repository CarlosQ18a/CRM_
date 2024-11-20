package com.example.CRM.dto

import java.time.LocalDateTime

data class ActivityDTO(
    val id: Long,
    val leadId: Long,
    val description: String,
    val date: LocalDateTime
)
