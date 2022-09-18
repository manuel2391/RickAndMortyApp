package com.mg.rickandmortyapp.ui.screens.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mg.rickandmortyapp.R
import com.mg.rickandmortyapp.models.PCharacter
import com.mg.rickandmortyapp.models.PCharacterGender
import com.mg.rickandmortyapp.models.PCharacterLocation
import com.mg.rickandmortyapp.models.PCharacterStatus
import com.mg.rickandmortyapp.ui.theme.Gray
import com.mg.rickandmortyapp.ui.theme.Green
import com.mg.rickandmortyapp.ui.theme.Light
import com.mg.rickandmortyapp.ui.theme.RickAndMortyAppTheme

@Composable
fun CharacterItem(
    modifier: Modifier = Modifier,
    character:PCharacter,
    onClick:(PCharacter)->Unit
){
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .clickable {
                onClick(character)
            }
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit,
            model = character.image,
            contentDescription = character.name
        )
        if(character.isDead){
            Icon(
                modifier = Modifier
                    .size(50.dp)
                    .padding(15.dp)
                    .align(Alignment.TopEnd),
                painter = painterResource(id = R.drawable.ic_skull),
                tint = Color.Black,
                contentDescription = null // decorative element
            )
        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Gray
                        )
                    )
                )
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = 15.dp,
                        horizontal = 10.dp
                    ),
                text = character.name,
                color = Light,
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Preview
@Composable
fun CharacterItemPreview(){
    RickAndMortyAppTheme {
        CharacterItem(
            character = PCharacter(
                id = 1,
                name = "Rick Sanchez",
                status = PCharacterStatus.ALIVE,
                species = "Human",
                type = "",
                gender = PCharacterGender.MALE,
                image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                created = "2017-12-29T18:51:29.693Z",
                origin = PCharacterLocation(
                    name = "Earth (C-500A)",
                    url = "https://rickandmortyapi.com/api/location/23"
                ),
                location = PCharacterLocation(
                    name = "Earth (C-500A)",
                    url = "https://rickandmortyapi.com/api/location/23"
                )
            ),
            onClick = {}
        )
    }
}