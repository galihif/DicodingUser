package com.giftech.dicodinguser

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.giftech.dicodinguser.ui.navigation.Screen
import com.giftech.dicodinguser.ui.screens.home.HomeScreen

@Composable
fun DicodingUserApp(
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = Modifier
    ){
        composable(Screen.Home.route){
            HomeScreen()
        }
    }
}