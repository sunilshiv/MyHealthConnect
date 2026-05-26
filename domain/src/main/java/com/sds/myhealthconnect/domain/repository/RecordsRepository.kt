package com.sds.myhealthconnect.domain.repository

import com.sds.myhealthconnect.domain.model.HealthRecord
import kotlinx.coroutines.flow.Flow

interface RecordsRepository {
    fun getHealthRecords(): Flow<List<HealthRecord>>
}
