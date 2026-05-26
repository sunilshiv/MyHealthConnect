package com.sds.myhealthconnect.miniapps.lab

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sds.myhealthconnect.domain.model.LabTest
import com.sds.myhealthconnect.domain.repository.LabRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class LabUiState(
    val tests: List<LabTest> = emptyList(),
    val isLoading: Boolean = false
)

@HiltViewModel
class LabViewModel @Inject constructor(
    private val labRepository: LabRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(LabUiState())
    val uiState: StateFlow<LabUiState> = _uiState.asStateFlow()

    init {
        loadTests()
    }

    private fun loadTests() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            labRepository.getLabTests().collect { tests ->
                _uiState.value = LabUiState(tests = tests, isLoading = false)
            }
        }
    }
}
