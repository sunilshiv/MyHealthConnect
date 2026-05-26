package com.sds.myhealthconnect.data.repository

import com.sds.myhealthconnect.domain.model.HealthRecord
import com.sds.myhealthconnect.domain.repository.RecordsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecordsRepositoryImpl @Inject constructor() : RecordsRepository {
    override fun getHealthRecords(): Flow<List<HealthRecord>> = flow {
        emit(
            listOf(
                HealthRecord("1", "Annual Blood Test", "Sept 12, 2023", "Report", "City Lab", "All parameters within normal range."),
                HealthRecord("2", "Chest X-Ray", "Aug 05, 2023", "History", "General Hospital", "Clear lungs, no abnormalities detected."),
                HealthRecord("3", "Antibiotics Prescription", "July 20, 2023", "Prescription", "Dr. Sarah Smith", "7-day course for throat infection.")
            )
        )
    }
}
