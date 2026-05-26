package com.sds.myhealthconnect.data.repository

import com.sds.myhealthconnect.domain.model.Medication
import com.sds.myhealthconnect.domain.repository.PharmacyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PharmacyRepositoryImpl @Inject constructor() : PharmacyRepository {
    override fun getMedications(): Flow<List<Medication>> = flow {
        emit(
            listOf(
                Medication("1", "Paracetamol", "500mg", 5.0, "Pain reliever and fever reducer"),
                Medication("2", "Amoxicillin", "250mg", 12.5, "Antibiotic for bacterial infections"),
                Medication("3", "Cetirizine", "10mg", 8.0, "Antihistamine for allergy symptoms"),
                Medication("4", "Ibuprofen", "400mg", 6.5, "Nonsteroidal anti-inflammatory drug"),
                Medication("5", "Metformin", "850mg", 15.0, "Used for blood sugar control in type 2 diabetes")
            )
        )
    }
}
