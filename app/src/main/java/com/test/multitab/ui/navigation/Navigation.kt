package com.test.multitab.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.test.multitab.ui.navigation.screens.CreateUserScreen
import com.test.multitab.ui.navigation.screens.HomeScreen

@Composable
fun Navigation() {
    
    val navController  = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ){
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(route = Screen.CreateUserScreen.route){
            CreateUserScreen(navController)
        }
    }
}


