package com.example.CRM.service

import com.example.CRM.dto.ActivityDTO
import com.example.CRM.model.Activity
import com.example.CRM.model.Lead
import com.example.CRM.repository.ActivityRepository
import com.example.CRM.repository.LeadRepository
import org.springframework.stereotype.Service

@Service
class ActivityService(
    private val activityRepository: ActivityRepository,
    private val leadRepository: LeadRepository // Asegúrate de tener acceso al repositorio de Lead
) {

    fun getAllActivities(): List<ActivityDTO> =
        activityRepository.findAll().map { activity ->
            ActivityDTO(activity.id, activity.lead.id, activity.description, activity.date)
        }

    fun getActivityById(id: Long): ActivityDTO? =
        activityRepository.findById(id).map { activity ->
            ActivityDTO(activity.id, activity.lead.id, activity.description, activity.date)
        }.orElse(null)

    fun createActivity(activityDTO: ActivityDTO): ActivityDTO {
        // Buscar el Lead completo por su ID
        val lead: Lead = leadRepository.findById(activityDTO.leadId)
            .orElseThrow { IllegalArgumentException("Lead not found with id: ${activityDTO.leadId}") }

        // Crear la nueva Activity usando el Lead completo
        val activity = Activity(
            lead = lead, // Usar el Lead completo
            description = activityDTO.description,
            date = activityDTO.date
        )
        val savedActivity = activityRepository.save(activity)
        return ActivityDTO(savedActivity.id, savedActivity.lead.id, savedActivity.description, savedActivity.date)
    }
}
