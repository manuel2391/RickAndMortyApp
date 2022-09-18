package com.mg.rickandmortyapp.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Destination{
    abstract val route: String
    open val arguments: List<NamedNavArgument> = emptyList()


    object CharactersNavGraph:Destination(){
        override val route: String
            get() = CHARACTERS_NAV_GRAPH_ROUTE
    }

    object CharactersScreenDestination:Destination(){
        override val route: String
            get() = CHARACTERS_SCREEN_ROUTE

    }

    object CharacterDetailScreenDestination:Destination(){
        private const val basePath = CHARACTER_DETAIL_SCREEN_ROUTE
        private const val argId = "characterId"

        override val arguments: List<NamedNavArgument>
            get() = listOf(
                navArgument(argId){type = NavType.IntType}
            )
        override val route: String
            get() = "$basePath/{$argId}"

        fun buildRoute(characterId:Int):String{
            return "$basePath/$characterId"
        }

    }




    companion object{
        private const val CHARACTERS_NAV_GRAPH_ROUTE = "characters_nav_graph"
        private const val CHARACTERS_SCREEN_ROUTE = "characters"
        private const val CHARACTER_DETAIL_SCREEN_ROUTE = "character"

    }

}
