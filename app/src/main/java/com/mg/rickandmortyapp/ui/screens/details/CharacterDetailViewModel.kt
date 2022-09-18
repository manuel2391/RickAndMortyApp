package com.mg.rickandmortyapp.ui.screens.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.mg.common_ui.base.BaseViewModel
import com.mg.domain.usecases.GetCharacter
import com.mg.rickandmortyapp.models.toPresentation
import com.mg.rickandmortyapp.ui.screens.details.CharacterDetailContract.CharacterDetailState
import com.mg.rickandmortyapp.ui.screens.details.CharacterDetailContract.CharacterDetailAction
import com.mg.rickandmortyapp.ui.screens.details.CharacterDetailContract.CharacterDetailEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacter: GetCharacter,
    private val savedStateHandle: SavedStateHandle
):BaseViewModel<CharacterDetailState,CharacterDetailAction,CharacterDetailEvent>(
    CharacterDetailState()
) {
    private val id:Int? = savedStateHandle.get("characterId")
    init {
        getCharacterById()
    }

    override suspend fun onActionReceived(action: CharacterDetailAction) {

    }

    private fun getCharacterById(){
        id?.let {
            id->
            viewModelScope.launch(Dispatchers.IO) {
                runCatching {
                    getCharacter(id)
                }.onSuccess {
                    response->
                    updateState {
                        copy(
                            character = response.toPresentation()
                        )
                    }
                }
            }
        }

    }
}