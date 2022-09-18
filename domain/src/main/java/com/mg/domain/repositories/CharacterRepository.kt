package com.mg.domain.repositories

import com.mg.domain.models.DCharacter
import com.mg.domain.models.DCharacterFilter

interface CharacterRepository {

    suspend fun getAllCharacters(filter:DCharacterFilter):List<DCharacter>

    suspend fun getCharacterById(id:Int):DCharacter

}