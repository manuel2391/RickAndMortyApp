package com.mg.rickandmortyapp.ui.screens.details

import android.graphics.Bitmap
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.palette.graphics.Palette
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.mg.rickandmortyapp.MainAppState
import com.mg.rickandmortyapp.R
import com.mg.rickandmortyapp.components.InfoTag
import com.mg.rickandmortyapp.components.TypeInfoTag
import com.mg.rickandmortyapp.ui.theme.Dark
import com.mg.rickandmortyapp.ui.theme.Gray
import com.mg.rickandmortyapp.ui.theme.Light

@Composable
fun CharacterDetailScreen(
    viewModel:CharacterDetailViewModel = hiltViewModel(),
    mainAppState: MainAppState
){
    val uiState by viewModel.state.collectAsState()

    CharacterDetailScreenContent(
        uiState = uiState,
        onBack = {
            mainAppState.navController.popBackStack()
        }
    )

}

@Composable
private fun CharacterDetailScreenContent(
    uiState: CharacterDetailContract.CharacterDetailState,
    onBack:()->Unit = {}
){
    val painter = rememberAsyncImagePainter(
        uiState.character?.image,
    )
    val backgroundColor = remember{ mutableStateOf(Dark) }
    val titleColor = remember{ mutableStateOf(Dark)}
    val state = painter.state
    if (state is AsyncImagePainter.State.Success) {
        LaunchedEffect(painter){
            val bitmap = painter.imageLoader.execute(painter.request).drawable?.toBitmap()?.copy(
                Bitmap.Config.ARGB_8888, true
            )
            bitmap?.let {
                Palette.from(it).generate {
                    palette->

                    val dominantSwatch = palette?.dominantSwatch
                    val vibrantSwatch = palette?.vibrantSwatch

                    vibrantSwatch?.let {
                        backgroundColor.value = Color(it.rgb)
                        titleColor.value = Color(it.titleTextColor)
                    }?: kotlin.run {
                        dominantSwatch?.let {
                            backgroundColor.value = Color(it.rgb)
                            titleColor.value = Color(it.titleTextColor)
                        }
                    }

                }

            }

        }
    }


    Surface(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            uiState.character?.let{
                character->

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.50F)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(.70f)
                            .background(
                                color = backgroundColor.value
                            )
                            .blur(20.dp)
                    ) {

                    }
                    ImageContainer(
                        modifier = Modifier
                            .fillMaxWidth(0.60F)
                            .aspectRatio(1F)
                            .align(Alignment.BottomCenter),
                        painter = painter
                    )


                    IconButton(
                        modifier = Modifier
                            .statusBarsPadding(),
                        onClick = onBack
                    ) {
                        Icon(
                            tint = titleColor.value,
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Back button"
                        )
                    }


                    Text(
                        modifier = Modifier
                            .padding(
                                top = 20.dp,
                                start = 30.dp,
                                end = 30.dp
                            )
                            .statusBarsPadding()
                            .fillMaxWidth(),
                        text = character.name,
                        style = MaterialTheme.typography.h2,
                        color = titleColor.value,
                        textAlign = TextAlign.Center
                    )

                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.50F)
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(5.dp)
                        ) {
                            InfoTag(
                                text = character.species.uppercase(),
                                type = TypeInfoTag.SPECIES
                            )
                            InfoTag(
                                text = character.status.name,
                                type = TypeInfoTag.STATUS
                            )

                            InfoTag(
                                text = character.gender.name,
                                type = TypeInfoTag.GENDER
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        TitleDetail(
                            modifier = Modifier.padding(
                              horizontal = 10.dp
                            ),
                            title = stringResource(id = R.string.character_origin),
                            content = character.origin.name,
                            color = backgroundColor.value,
                            painter = painterResource(id = R.drawable.ic_planet_earth)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        TitleDetail(
                            modifier = Modifier.padding(
                                horizontal = 10.dp
                            ),
                            title = stringResource(id = R.string.character_location),
                            content = character.location.name,
                            color = backgroundColor.value,
                            painter = painterResource(id = R.drawable.ic_planet),
                        )
                    }
                }
            }
        }
    }
}

@Composable fun ImageContainer(
    modifier: Modifier = Modifier,
    painter: AsyncImagePainter
){
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit,
            painter = painter,
            contentDescription = ""
        )
    }
}

@Composable fun TitleDetail(
    modifier: Modifier = Modifier,
    title:String,
    content:String,
    color:Color,
    painter: Painter
){

    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = title,
            style = MaterialTheme.typography.subtitle1
        )
        Divider(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                modifier = Modifier
                    .size(40.dp)
                    .padding(
                        end = 15.dp
                    )
                ,
                painter = painter,
                tint = color,
                contentDescription = null
            )
            Text(
                text = content
            )
        }
    }

}