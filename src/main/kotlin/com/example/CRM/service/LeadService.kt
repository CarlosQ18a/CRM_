package com.example.CRM.service

import com.example.CRM.dto.LeadDTO
import com.example.CRM.model.Lead
import com.example.CRM.repository.LeadRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LeadService {

    @Autowired
    private lateinit var leadRepository: LeadRepository

    // Obtener todos los leads
    fun getAllLeads(): List<LeadDTO> {
        val leads = leadRepository.findAll()
        return leads.map { lead -> LeadDTO(lead.id, lead.customerId, lead.source, lead.status) }
    }

    // Obtener un lead por ID
    fun getLeadById(id: Long): LeadDTO {
        val lead = leadRepository.findById(id).orElseThrow {
            throw RuntimeException("Lead not found with id: $id")
        }
        return LeadDTO(lead.id, lead.customerId, lead.source, lead.status)
    }

    // Crear un nuevo lead
    fun createLead(leadDTO: LeadDTO): LeadDTO {
        val lead = Lead(
            customerId = leadDTO.customerId,
            source = leadDTO.source,
            status = leadDTO.status,
            name = ""  // Establece un valor predeterminado para 'name' si es necesario
        )
        val savedLead = leadRepository.save(lead)
        return LeadDTO(savedLead.id, savedLead.customerId, savedLead.source, savedLead.status)
    }

    // Actualizar un lead existente
    fun updateLead(id: Long, leadDTO: LeadDTO): LeadDTO {
        val existingLead = leadRepository.findById(id).orElseThrow {
            throw RuntimeException("Lead not found with id: $id")
        }

        existingLead.customerId = leadDTO.customerId
        existingLead.source = leadDTO.source
        existingLead.status = leadDTO.status

        val savedLead = leadRepository.save(existingLead)
        return LeadDTO(savedLead.id, savedLead.customerId, savedLead.source, savedLead.status)
    }

    // Eliminar un lead por ID
    fun deleteLead(id: Long) {
        if (!leadRepository.existsById(id)) {
            throw RuntimeException("Lead not found with id: $id")
        }
        leadRepository.deleteById(id)
    }
}