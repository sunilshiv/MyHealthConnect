package com.sds.myhealthconnect.miniapps.pharmacy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sds.myhealthconnect.domain.model.Medication
import com.sds.myhealthconnect.domain.repository.PharmacyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PharmacyUiState(
    val medications: List<Medication> = emptyList(),
    val isLoading: Boolean = false
)

@HiltViewModel
class PharmacyViewModel @Inject constructor(
    private val pharmacyRepository: PharmacyRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(PharmacyUiState())
    val uiState: StateFlow<PharmacyUiState> = _uiState.asStateFlow()

    init {
        loadMedications()
    }

    private fun loadMedications() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            pharmacyRepository.getMedications().collect { meds ->
                _uiState.value = PharmacyUiState(medications = meds, isLoading = false)
            }
        }
    }
}
