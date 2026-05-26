package com.sds.myhealthconnect.features.records

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sds.myhealthconnect.core.ui.MyHealthConnectScaffold
import com.sds.myhealthconnect.domain.model.HealthRecord

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordsScreen(
    onBack: () -> Unit,
    viewModel: RecordsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    MyHealthConnectScaffold(
        topBar = {
            TopAppBar(
                title = { Text("Health Records") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        if (uiState.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                item {
                    Text(
                        text = "Your medical history and reports",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                items(uiState.records) { record ->
                    HealthRecordItem(record)
                    HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                }
            }
        }
    }
}

@Composable
fun HealthRecordItem(record: HealthRecord) {
    ListItem(
        headlineContent = { Text(record.title) },
        supportingContent = { Text("${record.provider} • ${record.summary}") },
        trailingContent = { Text(record.date, style = MaterialTheme.typography.labelSmall) },
        overlineContent = { Text(record.category, color = MaterialTheme.colorScheme.tertiary) }
    )
}
