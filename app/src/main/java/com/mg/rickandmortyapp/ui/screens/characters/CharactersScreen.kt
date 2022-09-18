package com.mg.rickandmortyapp.ui.screens.characters

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mg.rickandmortyapp.MainAppState
import com.mg.rickandmortyapp.R
import com.mg.rickandmortyapp.common.OnLastReached
import com.mg.rickandmortyapp.components.CharacterFilter
import com.mg.rickandmortyapp.models.PCharacter
import com.mg.rickandmortyapp.models.PCharacterFilter
import com.mg.rickandmortyapp.navigation.Destination
import com.mg.rickandmortyapp.ui.theme.Dark
import com.mg.rickandmortyapp.ui.theme.Green
import com.mg.rickandmortyapp.ui.theme.RickAndMortyAppTheme
import kotlinx.coroutines.launch

@Composable
fun CharactersScreen(
    viewModel: CharactersScreenViewModel = hiltViewModel(),
    mainAppState: MainAppState
){
    val viewState by viewModel.state.collectAsState()
    CharactersScreenContent(
        state = viewState,
        onClick = {
            mainAppState.navController.navigate(
                Destination.CharacterDetailScreenDestination.buildRoute(it.id)
            )
        },
        onLastReach = {
            viewModel.sendAction(CharactersContract.CharactersAction.NextPage)
        },
        onFilterChange = {
            viewModel.sendAction(CharactersContract.CharactersAction.Filter(it))
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun CharactersScreenContent(
    state: CharactersContract.CharactersState,
    onClick:(PCharacter)->Unit,
    onLastReach:()->Unit,
    onFilterChange:(PCharacterFilter)-> Unit = {}
){
    val lazyGridState = rememberLazyGridState()
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded }
    )
    val coroutineScope = rememberCoroutineScope()

    BackHandler(sheetState.isVisible) {
        coroutineScope.launch { sheetState.hide() }
    }
    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
            CharacterFilter(
                filter = state.filter,
                onChange = onFilterChange
            )
        },
        sheetShape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxSize(),
        scrimColor = Dark.copy(alpha = 0.6f)
    ) {

        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 16.dp
                    )
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .statusBarsPadding()
                        .padding(
                            bottom = 20.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .weight(1F),
                        text = stringResource(id = R.string.characters_title).uppercase(),
                        style = MaterialTheme.typography.h1,
                        color = Green
                    )

                    IconButton(
                        onClick = {
                            coroutineScope.launch {
                                if (sheetState.isVisible) sheetState.hide()
                                else sheetState.animateTo(ModalBottomSheetValue.Expanded)
                            }
                        }
                    ) {
                        BadgedBox(
                            badge = {
                                if(filterCount(filter = state.filter) > 0){
                                    Badge {
                                        Text(filterCount(filter = state.filter).toString())
                                    }
                                }
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_filter),
                                tint = Green,
                                contentDescription = null // decorative element
                            )
                        }

                    }
                }

                LazyVerticalGrid(
                    modifier = Modifier
                        .weight(1F),
                    contentPadding = WindowInsets.navigationBars.asPaddingValues(),
                    state = lazyGridState,
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    items(state.characters){
                            item->
                        CharacterItem(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1F),
                            character = item,
                            onClick = onClick
                        )
                    }
                }
            }

        }
    }


    lazyGridState.OnLastReached {
        if (!state.filter.lastPage){
            onLastReach()
        }
    }
}




@Composable
fun filterCount(filter:PCharacterFilter):Int{
    var count = 0

    if(filter.status != null){
        count += 1
    }

    if(filter.gender != null){
        count += 1
    }

    return count
}




@Preview
@Composable
private fun CharactersScreenContentPreview(){
    RickAndMortyAppTheme() {
        CharactersScreenContent(
            state = CharactersContract.CharactersState(),
            onClick = {},
            onLastReach = {}
        )
    }
}