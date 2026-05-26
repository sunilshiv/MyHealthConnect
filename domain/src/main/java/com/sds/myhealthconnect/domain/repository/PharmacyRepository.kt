package com.sds.myhealthconnect.domain.repository

import com.sds.myhealthconnect.domain.model.Medication
import kotlinx.coroutines.flow.Flow

interface PharmacyRepository {
    fun getMedications(): Flow<List<Medication>>
}
