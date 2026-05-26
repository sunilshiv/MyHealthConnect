package com.sds.myhealthconnect.features.records

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sds.myhealthconnect.domain.model.HealthRecord
import com.sds.myhealthconnect.domain.repository.RecordsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class RecordsUiState(
    val records: List<HealthRecord> = emptyList(),
    val isLoading: Boolean = false
)

@HiltViewModel
class RecordsViewModel @Inject constructor(
    private val recordsRepository: RecordsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(RecordsUiState())
    val uiState: StateFlow<RecordsUiState> = _uiState.asStateFlow()

    init {
        loadRecords()
    }

    private fun loadRecords() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            recordsRepository.getHealthRecords().collect { recs ->
                _uiState.value = RecordsUiState(records = recs, isLoading = false)
            }
        }
    }
}
