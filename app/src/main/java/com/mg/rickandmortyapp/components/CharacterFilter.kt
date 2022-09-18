package com.mg.rickandmortyapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mg.rickandmortyapp.R
import com.mg.rickandmortyapp.models.PCharacterFilter
import com.mg.rickandmortyapp.models.PCharacterGender
import com.mg.rickandmortyapp.models.PCharacterStatus
import com.mg.rickandmortyapp.ui.theme.Light
import com.mg.rickandmortyapp.ui.theme.RickAndMortyAppTheme

@Composable
fun CharacterFilter(
    filter:PCharacterFilter,
    onChange:(PCharacterFilter)->Unit = {}
){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        FilterTitle(
            text = stringResource(id = R.string.character_status)
        )
        GroupRadioButton(
            value = filter.status,
            values = PCharacterStatus.values().toList(),
            onValueChange = {
                newStatus->
                onChange(
                    filter.copy(
                        page = 1,
                        status = newStatus
                    )
                )
            }
        )

        FilterTitle(
            text = stringResource(id = R.string.character_gender)
        )
        GroupRadioButton(
            modifier = Modifier
                .padding(bottom = 10.dp),

            value = filter.gender,
            values = PCharacterGender.values().toList(),
            onValueChange = {
                newGender->
                onChange(
                    filter.copy(
                        page = 1,
                        gender = newGender
                    )
                )
            }
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 10.dp
                )
                .navigationBarsPadding()
            ,
            onClick = {
                onChange(
                    filter.copy(
                        page = 1,
                        gender = null,
                        status = null
                    )
                )
            }
        ) {
           Text(
               text = stringResource(id = R.string.clear_filter)
           )
        }

    }
}


@Composable
fun FilterTitle(
    modifier:Modifier = Modifier,
    text:String
){
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth(),
            text = text
        )
        Divider(
            modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth()
                .height(1.dp)
        )
    }
}

@Composable
fun <T> GroupRadioButton(
    modifier: Modifier = Modifier,
    value:T?,
    values:List<T>,
    onValueChange:(T)->Unit
){
    Column(modifier = modifier.fillMaxWidth()) {
        values.forEach{

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = it.toString() == value.toString(),
                    onClick = {
                        onValueChange(it)
                    },
                    enabled = true,
                    colors = RadioButtonDefaults.colors(selectedColor = Light)
                )
                Text(
                    text = it.toString()
                )
            }


        }
    }
}


@Preview
@Composable
fun CharacterFilterPreview(){
    RickAndMortyAppTheme() {
        CharacterFilter(
            filter = PCharacterFilter()
        )
    }
}