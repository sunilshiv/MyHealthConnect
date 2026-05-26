package com.sds.myhealthconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sds.myhealthconnect.core.designsystem.theme.MyHealthConnectTheme
import com.sds.myhealthconnect.core.navigation.NavigationDestination
import com.sds.myhealthconnect.features.home.HomeScreen
import com.sds.myhealthconnect.features.appointment.AppointmentScreen
import com.sds.myhealthconnect.features.records.RecordsScreen
import com.sds.myhealthconnect.miniapps.lab.LabScreen
import com.sds.myhealthconnect.miniapps.pharmacy.PharmacyScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyHealthConnectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationDestination.Home.route
    ) {
        composable(NavigationDestination.Home.route) {
            HomeScreen(
                onNavigateToPharmacy = { navController.navigate(NavigationDestination.Pharmacy.route) },
                onNavigateToLab = { navController.navigate(NavigationDestination.Lab.route) },
                onNavigateToAppointments = { navController.navigate(NavigationDestination.Appointments.route) },
                onNavigateToRecords = { navController.navigate(NavigationDestination.Records.route) }
            )
        }
        composable(NavigationDestination.Pharmacy.route) {
            PharmacyScreen(onBack = { navController.popBackStack() })
        }
        composable(NavigationDestination.Lab.route) {
            LabScreen(onBack = { navController.popBackStack() })
        }
        composable(NavigationDestination.Appointments.route) {
            AppointmentScreen(onBack = { navController.popBackStack() })
        }
        composable(NavigationDestination.Records.route) {
            RecordsScreen(onBack = { navController.popBackStack() })
        }
    }
}
