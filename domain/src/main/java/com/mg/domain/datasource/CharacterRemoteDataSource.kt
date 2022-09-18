package com.mg.domain.datasource

import com.mg.domain.models.DCharacter
import com.mg.domain.models.DCharacterFilter

interface CharacterRemoteDataSource {

    suspend fun getAllCharacters(filter: DCharacterFilter):List<DCharacter>

    suspend fun getCharacterById(id:Int): DCharacter

}