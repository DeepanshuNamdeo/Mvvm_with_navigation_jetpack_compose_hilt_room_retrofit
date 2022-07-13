package com.test.multitab.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.test.multitab.ui.navigation.Screen

@Composable
fun AppTopBar(navController: NavController) {
    TopAppBar(
        title = { Text(text = "TEST") },
        actions = {
            IconButton(
                onClick = {
                    navController.navigate(Screen.CreateUserScreen.route)
                },
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Create new user"
                )
            }
        },
    )
}