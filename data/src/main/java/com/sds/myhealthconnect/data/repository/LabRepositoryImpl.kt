package com.sds.myhealthconnect.data.repository

import com.sds.myhealthconnect.domain.model.LabTest
import com.sds.myhealthconnect.domain.repository.LabRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LabRepositoryImpl @Inject constructor() : LabRepository {
    override fun getLabTests(): Flow<List<LabTest>> = flow {
        emit(
            listOf(
                LabTest("1", "Full Blood Count", "Blood", 45.0, "Fasting required for 8 hours"),
                LabTest("2", "Lipid Profile", "Blood", 60.0, "Fasting required for 12 hours"),
                LabTest("3", "HbA1c", "Blood", 35.0, "No fasting required"),
                LabTest("4", "Urine Routine", "Urine", 20.0, "First morning sample preferred"),
                LabTest("5", "Thyroid Profile", "Blood", 55.0, "No fasting required")
            )
        )
    }
}
