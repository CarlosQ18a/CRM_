package com.example.CRM.controller

import com.example.CRM.dto.ActivityDTO
import com.example.CRM.service.ActivityService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/activity")
class ActivityController(private val activityService: ActivityService) {

    @GetMapping
    fun getAllActivities(): List<ActivityDTO> = activityService.getAllActivities()

    @GetMapping("/{id}")
    fun getActivityById(@PathVariable id: Long): ActivityDTO? = activityService.getActivityById(id)

    @PostMapping
    fun createActivity(@RequestBody activityDTO: ActivityDTO): ActivityDTO = activityService.createActivity(activityDTO)
}
