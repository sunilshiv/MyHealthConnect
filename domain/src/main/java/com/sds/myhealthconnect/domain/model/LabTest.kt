package com.sds.myhealthconnect.domain.model

data class LabTest(
    val id: String,
    val name: String,
    val category: String,
    val price: Double,
    val preparation: String
)
