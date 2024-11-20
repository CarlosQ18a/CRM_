package com.example.CRM.model

import jakarta.persistence.*

@Entity
@Table(name = "leads")
data class Lead(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,  // 'var' en lugar de 'val'

    @Column(name = "customer_id")
    var customerId: Long,  // 'var' en lugar de 'val'

    @Column(name = "source")
    var source: String,  // 'var' en lugar de 'val'

    @Column(name = "status")
    var status: String,  // 'var' en lugar de 'val'

    @Column(name = "name")
    var name: String,  // Agregado el campo 'name'
)
