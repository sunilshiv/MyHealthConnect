package com.sds.myhealthconnect.data.repository

import com.sds.myhealthconnect.domain.model.Appointment
import com.sds.myhealthconnect.domain.repository.AppointmentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppointmentRepositoryImpl @Inject constructor() : AppointmentRepository {
    override fun getAppointments(): Flow<List<Appointment>> = flow {
        emit(
            listOf(
                Appointment("1", "Dr. Sarah Smith", "Cardiologist", "Oct 24, 2023 - 10:00 AM", "Consultation", "Confirmed"),
                Appointment("2", "Dr. Mike Jones", "Dermatologist", "Nov 02, 2023 - 02:30 PM", "Follow-up", "Pending"),
                Appointment("3", "Dr. Emily Brown", "General Practitioner", "Nov 15, 2023 - 09:15 AM", "Annual Checkup", "Confirmed")
            )
        )
    }
}
