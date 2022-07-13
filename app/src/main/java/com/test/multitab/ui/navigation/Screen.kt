package com.test.multitab.ui.navigation

sealed class Screen(val route : String ){
    object HomeScreen : Screen("Home_screen")
    object CreateUserScreen : Screen("create_user_screen")
}
