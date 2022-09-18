package com.mg.common

import com.mg.common.api.ApiCallHandler
import com.mg.common.api.ApiCallHandlerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CommonModule {
    @Provides
    @Singleton
    fun provideApiCallHandler(): ApiCallHandler {
        return ApiCallHandlerImpl(
            dispatcher = Dispatchers.IO,
            numRetries = 3
        )
    }
}