package com.example.finema.api

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
                .newBuilder()
                .addHeader("x-rapidapi-key", "4d5f54a091msh6e49adf8a925a8ep1118b4jsna0715bba70a3")
                .addHeader("x-rapidapi-host", "imdb8.p.rapidapi.com")
                .build()

        return chain.proceed(request)
    }
}