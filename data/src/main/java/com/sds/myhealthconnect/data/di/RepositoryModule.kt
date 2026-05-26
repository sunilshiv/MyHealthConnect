package com.sds.myhealthconnect.data.di

import com.sds.myhealthconnect.data.repository.AppointmentRepositoryImpl
import com.sds.myhealthconnect.data.repository.LabRepositoryImpl
import com.sds.myhealthconnect.data.repository.PharmacyRepositoryImpl
import com.sds.myhealthconnect.data.repository.RecordsRepositoryImpl
import com.sds.myhealthconnect.domain.repository.AppointmentRepository
import com.sds.myhealthconnect.domain.repository.LabRepository
import com.sds.myhealthconnect.domain.repository.PharmacyRepository
import com.sds.myhealthconnect.domain.repository.RecordsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPharmacyRepository(
        pharmacyRepositoryImpl: PharmacyRepositoryImpl
    ): PharmacyRepository

    @Binds
    @Singleton
    abstract fun bindLabRepository(
        labRepositoryImpl: LabRepositoryImpl
    ): LabRepository

    @Binds
    @Singleton
    abstract fun bindAppointmentRepository(
        appointmentRepositoryImpl: AppointmentRepositoryImpl
    ): AppointmentRepository

    @Binds
    @Singleton
    abstract fun bindRecordsRepository(
        recordsRepositoryImpl: RecordsRepositoryImpl
    ): RecordsRepository
}
