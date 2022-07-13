package com.test.multitab.ui.navigation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.test.multitab.ui.components.AppTopBar
import com.test.multitab.ui.components.TabLayout
import com.test.multitab.ui.navigation.Screen
import com.test.multitab.ui.theme.MuiltTabTheme

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    MuiltTabTheme() {
        Scaffold(
            backgroundColor = MaterialTheme.colors.background,
            topBar = {
                AppTopBar(navController)
            }) {
            TabLayout(modifier = Modifier.padding(it))
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
   // HomeScreen()
}