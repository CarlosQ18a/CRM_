package com.example.CRM.repository

import com.example.CRM.model.Lead
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LeadRepository : JpaRepository<Lead, Long>