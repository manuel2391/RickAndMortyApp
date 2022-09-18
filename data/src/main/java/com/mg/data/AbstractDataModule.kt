package com.mg.data

import com.mg.data.datasource.character.CharacterRemoteDataSourceImpl
import com.mg.data.repositories.CharacterRepositoryImpl
import com.mg.domain.datasource.CharacterRemoteDataSource
import com.mg.domain.repositories.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AbstractDataModule {


    @Binds
    @Singleton
    abstract fun bindCharacterRemoteDataSource(
        characterRemoteDataSourceImpl: CharacterRemoteDataSourceImpl
    ):CharacterRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindCharacterRepository(
        characterRepositoryImpl: CharacterRepositoryImpl
    ):CharacterRepository

}