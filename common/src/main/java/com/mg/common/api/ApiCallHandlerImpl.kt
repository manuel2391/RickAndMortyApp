package com.mg.common.api

import com.mg.common.failure.ApiFailure
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class ApiCallHandlerImpl @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val numRetries: Long
) : ApiCallHandler {

    override suspend fun <T> process(apiCall: suspend () -> Response<T>): Result<T> {
        return withContext(dispatcher) {
            try {
                val response = apiCall.invoke()
                if (response.isSuccessful) {
                    return@withContext Result.success(response.body()!!)
                } else {
                    // todo here we can implement a refresh token logic if we have
                    val error =
                        processFailure(response.code(), response.errorBody()?.string().toString())
                    return@withContext Result.failure(error)
                }
            } catch (throwable: Throwable) {
                // todo here we should take some actions, like send a event bus to navigate to authenticate
                return@withContext Result.failure(throwable)
            }
        }
    }

    /**
     * This method transform an error response into a custom Throwable called [ApiFailure]
     */
    private fun processFailure(errorCode: Int, errorBody: String): ApiFailure {
        return when (errorCode) {
            HttpStatusCode.ClientError.Unauthorized.code -> ApiFailure.AuthRequiredError
            HttpStatusCode.ClientError.Forbidden.code -> ApiFailure.ForbiddenError
            HttpStatusCode.ClientError.NotFound.code -> ApiFailure.NotFoundError
            else -> ApiFailure.ServiceUnavailableError(errorBody)
        }
    }
}