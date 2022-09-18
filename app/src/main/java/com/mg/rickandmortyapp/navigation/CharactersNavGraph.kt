package com.mg.rickandmortyapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mg.rickandmortyapp.MainAppState
import com.mg.rickandmortyapp.ui.screens.characters.CharactersScreen
import com.mg.rickandmortyapp.ui.screens.details.CharacterDetailScreen

fun NavGraphBuilder.addCharactersNavGraph(
    mainAppState: MainAppState
){
    navigation(
        route = Destination.CharactersNavGraph.route,
        startDestination = Destination.CharactersScreenDestination.route
    ){
        composable(
            route = Destination.CharactersScreenDestination.route
        ){
            CharactersScreen(
                mainAppState = mainAppState
            )
        }

        composable(
            route = Destination.CharacterDetailScreenDestination.route,
            arguments = Destination.CharacterDetailScreenDestination.arguments
        ){
            CharacterDetailScreen(
                mainAppState = mainAppState
            )
        }
    }
}