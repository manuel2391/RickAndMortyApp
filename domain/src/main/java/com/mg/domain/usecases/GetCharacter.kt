package com.mg.domain.usecases

import com.mg.domain.models.DCharacter
import com.mg.domain.repositories.CharacterRepository
import javax.inject.Inject

class GetCharacter @Inject constructor(
    private val characterRepository: CharacterRepository
) {

    suspend operator fun invoke(id:Int):DCharacter = characterRepository.getCharacterById(id)

}