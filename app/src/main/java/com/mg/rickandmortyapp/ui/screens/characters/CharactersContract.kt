package com.mg.rickandmortyapp.ui.screens.characters

import com.mg.common_ui.base.LoadState
import com.mg.common_ui.base.ViewAction
import com.mg.common_ui.base.ViewEvent
import com.mg.common_ui.base.ViewState
import com.mg.rickandmortyapp.models.PCharacter
import com.mg.rickandmortyapp.models.PCharacterFilter

class CharactersContract {
    data class CharactersState(
        val loadState:LoadState = LoadState.IDLE,
        val characters:List<PCharacter> = listOf(),
        val filter:PCharacterFilter = PCharacterFilter()
    ):ViewState

    sealed class CharactersAction: ViewAction{
        object NextPage : CharactersAction()

        data class Filter(
            val update:PCharacterFilter
            ): CharactersAction()
    }

    sealed class CharactersEvent: ViewEvent

}