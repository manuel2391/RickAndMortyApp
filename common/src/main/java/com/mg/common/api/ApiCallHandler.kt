package com.mg.common.api

import retrofit2.Response

interface ApiCallHandler {
    suspend fun <T> process(apiCall: suspend () -> Response<T>): Result<T>
}