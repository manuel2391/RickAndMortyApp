package com.mg.data.datasource.character

import com.mg.common.api.ApiCallHandler
import com.mg.common.failure.ApiFailure
import com.mg.data.remote.api.CharacterApiService
import com.mg.domain.datasource.CharacterRemoteDataSource
import com.mg.domain.models.DCharacter
import com.mg.domain.models.DCharacterFilter
import javax.inject.Inject

class CharacterRemoteDataSourceImpl @Inject constructor(
    private val apiCallHandler: ApiCallHandler,
    private val characterApiService: CharacterApiService
):CharacterRemoteDataSource {

    override suspend fun getAllCharacters(filter: DCharacterFilter): List<DCharacter> {
        return try {
            val response = apiCallHandler.process {
                characterApiService.getAllTheCharacters(
                    page = filter.page,
                    name = filter.name,
                    status = filter.status,
                    species = filter.species,
                    type = filter.type,
                    gender = filter.gender
                )
            }.mapCatching {
                it.results
            }
            response.getOrNull()?: throw ApiFailure.ServiceUnavailableError()
        }catch (throwable:Throwable){
            throw throwable
        }
    }

    override suspend fun getCharacterById(id: Int): DCharacter {
        return try {
            val response = apiCallHandler.process {
                characterApiService.getCharacter(id)
            }.mapCatching {
                it
            }
            response.getOrNull()?: throw ApiFailure.ServiceUnavailableError()

        }catch (throwable:Throwable){
            throw throwable
        }
    }
}