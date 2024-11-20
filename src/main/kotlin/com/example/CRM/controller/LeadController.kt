package com.example.CRM.controller

import com.example.CRM.dto.LeadDTO
import com.example.CRM.service.LeadService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/leads")
class LeadController {

    @Autowired
    private lateinit var leadService: LeadService

    // Obtener todos los leads
    @GetMapping
    fun getAllLeads(): List<LeadDTO> {
        return leadService.getAllLeads()
    }

    // Obtener un lead por ID
    @GetMapping("/{id}")
    fun getLeadById(@PathVariable id: Long): LeadDTO {
        return leadService.getLeadById(id)
    }

    // Crear un nuevo lead
    @PostMapping
    fun createLead(@RequestBody leadDTO: LeadDTO): LeadDTO {
        return leadService.createLead(leadDTO)
    }

    // Actualizar un lead por ID
    @PutMapping("/{id}")
    fun updateLead(@PathVariable id: Long, @RequestBody leadDTO: LeadDTO): LeadDTO {
        return leadService.updateLead(id, leadDTO)
    }

    // Eliminar un lead por ID
    @DeleteMapping("/{id}")
    fun deleteLead(@PathVariable id: Long) {
        leadService.deleteLead(id)
    }
}

