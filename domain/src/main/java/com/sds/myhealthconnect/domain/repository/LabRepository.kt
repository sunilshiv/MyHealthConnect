package com.sds.myhealthconnect.domain.repository

import com.sds.myhealthconnect.domain.model.LabTest
import kotlinx.coroutines.flow.Flow

interface LabRepository {
    fun getLabTests(): Flow<List<LabTest>>
}
