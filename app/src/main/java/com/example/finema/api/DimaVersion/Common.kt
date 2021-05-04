package com.example.finema.api.DimaVersion

import com.example.finema.api.RetrofitClient
import com.example.finema.utlis.BASE_URL

object Common {
    val retrofitService: ApiInterface
        get() = RetroClient.getClient(BASE_URL).create(ApiInterface::class.java)
}