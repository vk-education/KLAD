package com.example.finema.repositories

import java.io.IOException
import retrofit2.Response

interface SafeApiRequest {

    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            // @todo handle api exception
            throw ApiException(response.code().toString())
        }
    }
}

class ApiException(message: String) : IOException(message)
