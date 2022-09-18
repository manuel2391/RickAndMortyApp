package com.mg.data.repositories

import com.mg.domain.datasource.CharacterRemoteDataSource
import com.mg.domain.models.DCharacter
import com.mg.domain.models.DCharacterFilter
import com.mg.domain.repositories.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val characterRemoteDataSource: CharacterRemoteDataSource
):CharacterRepository {
    override suspend fun getAllCharacters(filter: DCharacterFilter): List<DCharacter> {
        return characterRemoteDataSource.getAllCharacters(filter)
    }

    override suspend fun getCharacterById(id: Int): DCharacter {
        return characterRemoteDataSource.getCharacterById(id)
    }
}