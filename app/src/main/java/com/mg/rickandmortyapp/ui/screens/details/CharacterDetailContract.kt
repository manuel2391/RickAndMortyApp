package com.mg.rickandmortyapp.ui.screens.details

import com.mg.common_ui.base.ViewAction
import com.mg.common_ui.base.ViewEvent
import com.mg.common_ui.base.ViewState
import com.mg.rickandmortyapp.models.PCharacter

class CharacterDetailContract {

    data class CharacterDetailState(
        val character:PCharacter? = null
    ):ViewState

    sealed class CharacterDetailAction:ViewAction{

    }

    sealed class CharacterDetailEvent:ViewEvent
}