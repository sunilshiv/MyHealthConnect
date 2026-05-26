package com.sds.myhealthconnect.domain.model

data class HealthRecord(
    val id: String,
    val title: String,
    val date: String,
    val category: String, // e.g., "Report", "Prescription", "History"
    val provider: String,
    val summary: String
)
