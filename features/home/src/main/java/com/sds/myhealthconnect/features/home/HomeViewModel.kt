package com.sds.myhealthconnect.features.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class HealthMetric(
    val label: String,
    val value: String,
    val unit: String,
    val trend: String? = null
)

data class HomeUiState(
    val healthMetrics: List<HealthMetric> = emptyList(),
    val userName: String = "John Doe"
)

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadHomeData()
    }

    private fun loadHomeData() {
        _uiState.value = HomeUiState(
            healthMetrics = listOf(
                HealthMetric("Steps", "8,432", "steps", "+12%"),
                HealthMetric("Heart Rate", "72", "bpm", "-2%"),
                HealthMetric("Sleep", "7.5", "hrs", "+5%"),
                HealthMetric("Weight", "75.2", "kg", "Stable")
            )
        )
    }
}
