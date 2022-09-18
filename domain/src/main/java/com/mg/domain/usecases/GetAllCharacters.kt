package com.mg.domain.usecases

import com.mg.domain.models.DCharacter
import com.mg.domain.models.DCharacterFilter
import com.mg.domain.repositories.CharacterRepository
import javax.inject.Inject

class GetAllCharacters @Inject constructor(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(
        filter:DCharacterFilter
    ):List<DCharacter> = characterRepository.getAllCharacters(filter)

}