package com.sds.myhealthconnect.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Biotech
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.LocalPharmacy
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sds.myhealthconnect.core.designsystem.theme.MyHealthConnectTheme
import com.sds.myhealthconnect.core.ui.MyHealthConnectScaffold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToPharmacy: () -> Unit,
    onNavigateToLab: () -> Unit,
    onNavigateToAppointments: () -> Unit,
    onNavigateToRecords: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    MyHealthConnectScaffold(
        topBar = {
            TopAppBar(
                title = { Text("MyHealthConnect") },
                actions = {
                    Icon(
                        imageVector = Icons.Rounded.AccountCircle,
                        contentDescription = "Profile",
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(
                text = "Hello, ${uiState.userName}",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "Health Overview", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(uiState.healthMetrics) { metric ->
                    HealthMetricCard(metric)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Quick Services", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))

            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    ServiceCard(
                        title = "Pharmacy",
                        icon = Icons.Rounded.LocalPharmacy,
                        onClick = onNavigateToPharmacy,
                        modifier = Modifier.weight(1f)
                    )
                    ServiceCard(
                        title = "Lab Tests",
                        icon = Icons.Rounded.Biotech,
                        onClick = onNavigateToLab,
                        modifier = Modifier.weight(1f)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    ServiceCard(
                        title = "Appointments",
                        icon = Icons.Rounded.CalendarMonth,
                        onClick = onNavigateToAppointments,
                        modifier = Modifier.weight(1f)
                    )
                    ServiceCard(
                        title = "Records",
                        icon = Icons.Rounded.History,
                        onClick = onNavigateToRecords,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun HealthMetricCard(metric: HealthMetric) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        modifier = Modifier.height(100.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = metric.label, style = MaterialTheme.typography.labelMedium)
            Row(verticalAlignment = Alignment.Bottom) {
                Text(text = metric.value, style = MaterialTheme.typography.headlineSmall)
                Text(
                    text = " ${metric.unit}",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServiceCard(
    title: String,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        modifier = modifier.height(100.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(imageVector = icon, contentDescription = title, modifier = Modifier.padding(4.dp))
            Text(text = title, style = MaterialTheme.typography.titleSmall)
        }
    }
}

@Preview(showBackground = true, device = "spec:width=411dp,height=891dp")
@Composable
fun HomeScreenPreview() {
    MyHealthConnectTheme {
        HomeScreen(
            onNavigateToPharmacy = {},
            onNavigateToLab = {},
            onNavigateToAppointments = {},
            onNavigateToRecords = {}
        )
    }
}
