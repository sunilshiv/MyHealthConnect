package com.sds.myhealthconnect.core.navigation

sealed class NavigationDestination(val route: String) {
    object Home : NavigationDestination("home")
    object Pharmacy : NavigationDestination("pharmacy")
    object Lab : NavigationDestination("lab")
    object Profile : NavigationDestination("profile")
    object Appointments : NavigationDestination("appointments")
    object Records : NavigationDestination("records")
}
