package com.mg.rickandmortyapp

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class MainAppState(
    val scaffoldState: ScaffoldState,
    val navController: NavHostController
) {

}

@Composable
fun rememberMainAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController()

) = remember(scaffoldState, navController) {
    MainAppState(scaffoldState, navController)
}