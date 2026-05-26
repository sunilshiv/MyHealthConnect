package com.sds.myhealthconnect.domain.model

data class Medication(
    val id: String,
    val name: String,
    val dosage: String,
    val price: Double,
    val description: String,
    val imageUrl: String? = null
)
