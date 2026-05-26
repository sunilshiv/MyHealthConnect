package com.sds.myhealthconnect.features.appointment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sds.myhealthconnect.domain.model.Appointment
import com.sds.myhealthconnect.domain.repository.AppointmentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AppointmentUiState(
    val appointments: List<Appointment> = emptyList(),
    val isLoading: Boolean = false
)

@HiltViewModel
class AppointmentViewModel @Inject constructor(
    private val appointmentRepository: AppointmentRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AppointmentUiState())
    val uiState: StateFlow<AppointmentUiState> = _uiState.asStateFlow()

    init {
        loadAppointments()
    }

    private fun loadAppointments() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            appointmentRepository.getAppointments().collect { apps ->
                _uiState.value = AppointmentUiState(appointments = apps, isLoading = false)
            }
        }
    }
}
