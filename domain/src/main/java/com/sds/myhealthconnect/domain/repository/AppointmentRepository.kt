package com.sds.myhealthconnect.domain.repository

import com.sds.myhealthconnect.domain.model.Appointment
import kotlinx.coroutines.flow.Flow

interface AppointmentRepository {
    fun getAppointments(): Flow<List<Appointment>>
}
