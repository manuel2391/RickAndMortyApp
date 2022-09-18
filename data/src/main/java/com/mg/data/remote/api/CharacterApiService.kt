package com.mg.data.remote.api

import com.mg.data.remote.response.CharactersResponse
import com.mg.domain.models.DCharacter
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {

    @GET(CHARACTER_URL)
    suspend fun getAllTheCharacters(
        @Query("page") page:Int? = null,
        @Query("name") name:String? = null,
        @Query("status") status:String? = null,
        @Query("species") species:String? = null,
        @Query("type") type:String? = null,
        @Query("gender") gender:String? = null
    ): Response<CharactersResponse>

    @GET("$CHARACTER_URL{id}")
    suspend fun getCharacter(
        @Path("id") id:Int
    ):Response<DCharacter>



    companion object{
        private const val CHARACTER_URL = "character/"
    }

}