package com.example.CRM.model

import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "activity")
data class Activity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "lead_id")
    val lead: Lead,

    @Column(nullable = false)
    val description: String,

    @Column(nullable = false)
    val date: LocalDateTime
)