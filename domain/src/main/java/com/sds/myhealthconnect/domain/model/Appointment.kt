package com.sds.myhealthconnect.domain.model

data class Appointment(
    val id: String,
    val doctorName: String,
    val specialty: String,
    val dateTime: String,
    val type: String, // e.g., "Consultation", "Follow-up"
    val status: String // e.g., "Confirmed", "Pending"
)
