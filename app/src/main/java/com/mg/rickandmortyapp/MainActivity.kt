package com.mg.rickandmortyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import com.mg.rickandmortyapp.navigation.Destination
import com.mg.rickandmortyapp.navigation.addCharactersNavGraph
import com.mg.rickandmortyapp.ui.theme.RickAndMortyAppTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var mainAppState: MainAppState
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            mainAppState = rememberMainAppState()
            RickAndMortyAppTheme {
                App(mainAppState = mainAppState)
            }
        }
    }
}

@Composable
fun App(
    mainAppState: MainAppState
){
    Scaffold(
        scaffoldState = mainAppState.scaffoldState
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = mainAppState.navController,
            startDestination = Destination.CharactersNavGraph.route
        ){
            addCharactersNavGraph(
               mainAppState = mainAppState
            )
        }
    }

}
