package com.sds.myhealthconnect.features.appointment

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
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.sds.myhealthconnect.domain.model.Appointment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppointmentScreen(
    onBack: () -> Unit,
    viewModel: AppointmentViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    MyHealthConnectScaffold(
        topBar = {
            TopAppBar(
                title = { Text("Appointments") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* TODO: Schedule new */ }) {
                Icon(Icons.Rounded.Add, contentDescription = "Schedule New")
            }
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
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    Text(text = "Upcoming Appointments", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(16.dp))
                }
                items(uiState.appointments) { appointment ->
                    AppointmentCard(appointment)
                }
            }
        }
    }
}

@Composable
fun AppointmentCard(appointment: Appointment) {
    ElevatedCard(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = appointment.doctorName, style = MaterialTheme.typography.titleMedium)
                Text(
                    text = appointment.status,
                    style = MaterialTheme.typography.labelSmall,
                    color = if (appointment.status == "Confirmed") MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                )
            }
            Text(text = appointment.specialty, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = appointment.dateTime, style = MaterialTheme.typography.bodySmall)
            Text(text = appointment.type, style = MaterialTheme.typography.labelMedium)
        }
    }
}
