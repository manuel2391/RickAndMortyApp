package com.mg.rickandmortyapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mg.rickandmortyapp.ui.theme.*

@Composable
fun InfoTag(
    modifier: Modifier = Modifier,
    text:String,
    type:TypeInfoTag
){
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(
                color = type.color
            ),
    ) {
        Text(
            modifier = Modifier.padding(
                horizontal = 15.dp,
                vertical = 5.dp
            ),
            text = text.uppercase(),
            color = type.textColor,
            style = MaterialTheme.typography.infoTagText
        )
    }
}

@Preview
@Composable
fun InfoTagSpeciesPreview(){
    RickAndMortyAppTheme {
        InfoTag(
            text = "Alien",
            type = TypeInfoTag.SPECIES
        )
    }
}

@Preview
@Composable
fun InfoTagGenderPreview(){
    RickAndMortyAppTheme {
        InfoTag(
            text = "Male",
            type = TypeInfoTag.GENDER
        )
    }
}

@Preview
@Composable
fun InfoTagStatusPreview(){
    RickAndMortyAppTheme {
        InfoTag(
            text = "Alive",
            type = TypeInfoTag.STATUS
        )
    }
}

enum class TypeInfoTag(
    val color:Color,
    val textColor:Color
){
    GENDER(
        color = Green,
        textColor = Gray
    ),
    STATUS(
        color = Rose,
        textColor = Gray
    ),
    SPECIES(
        color = Yellow,
        textColor = Gray
    )
}