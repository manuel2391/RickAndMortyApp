package com.mg.rickandmortyapp.ui.screens.characters

import androidx.lifecycle.viewModelScope
import com.mg.common_ui.base.BaseViewModel
import com.mg.common_ui.base.LoadState
import com.mg.domain.usecases.GetAllCharacters
import com.mg.rickandmortyapp.models.PCharacter
import com.mg.rickandmortyapp.models.PCharacterFilter
import com.mg.rickandmortyapp.models.toPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.mg.rickandmortyapp.ui.screens.characters.CharactersContract.CharactersState
import com.mg.rickandmortyapp.ui.screens.characters.CharactersContract.CharactersAction
import com.mg.rickandmortyapp.ui.screens.characters.CharactersContract.CharactersEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@HiltViewModel
class CharactersScreenViewModel @Inject constructor(
  private val getAllCharacters: GetAllCharacters
):BaseViewModel<CharactersState,CharactersAction,CharactersEvent>(CharactersState()) {

    init {
        getAllCharactersService()
    }

    override suspend fun onActionReceived(action: CharactersAction) {
        when(action){
            CharactersAction.NextPage -> {
                nextPage()
            }

            is CharactersAction.Filter -> {
                updateFilter(action.update)
            }
        }
    }

    private fun nextPage(){
        var page:Int = state.value.filter.page
        page += 1
        updateState {
            copy(
                filter = this.filter.copy(page = page)
            )
        }
        getAllCharactersService()
    }

    private fun updateFilter(filterUpdate:PCharacterFilter){
        updateState {
            copy(
                filter = filterUpdate
            )
        }
        getAllCharactersService()
    }

    private fun getAllCharactersService(){
        viewModelScope.launch(Dispatchers.IO) {
            val filter = state.value.filter
            runCatching {
                getAllCharacters(filter.toDomain())
            }.onSuccess {
                list->

                if(list.isEmpty()){
                    updateState {
                        copy(
                            loadState = LoadState.CONTENT,
                            filter = this.filter.copy(lastPage = true)
                        )
                    }
                }else{
                    val characterList:MutableList<PCharacter> = mutableListOf()
                    if(filter.page == 1){
                        characterList.addAll(list.map { it.toPresentation() })
                    }else{
                        characterList.addAll(state.value.characters.toMutableList())
                        characterList.addAll(list.map { it.toPresentation() })

                    }
                    updateState {
                        copy(
                            loadState = LoadState.CONTENT,
                            characters = characterList.toList().sortedBy { it.id }
                        )
                    }
                }

            }.onFailure {



            }
        }
    }

}