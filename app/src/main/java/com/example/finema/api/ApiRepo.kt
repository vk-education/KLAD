package com.example.finema.api

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.example.finema.models.OverviewMode.OverviewModel
import com.example.finema.models.TMDBMovie
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random

class ApiRepo {
    private var instance: ApiRepo? = null
    private val dataSet : ArrayList<OverviewModel?> = ArrayList()
    private var dataSetTMDB: ArrayList<TMDBMovie?> = ArrayList()

    val API_KEY = "bbf5a3000e95f1dddf266b5e187d4b21"


    fun getInstance(): ApiRepo? {
        if(instance==null){
            instance = ApiRepo()
        }
        return instance
    }

    fun getApiRepo(): MutableLiveData<List<TMDBMovie?>> {
        setApiRepo()
        val data : MutableLiveData<List<TMDBMovie?>> = MutableLiveData()
        data.value = dataSetTMDB
        return data
    }

    private fun setApiRepo(){
        dataSetTMDB.clear()
        getMovieDataTMDB()
        getMovieDataTMDB()
    }

    private fun getMovieData() {
        runBlocking {
            val apiService = MovieApiService.getInstance().create(RetrofitInterface::class.java)
            apiService.getMovie(id = generateRandomId()).enqueue(object : Callback<OverviewModel> {
                override fun onFailure(call: Call<OverviewModel>, t: Throwable) {
                    Log.d("RESPONSE ${Thread.currentThread().name}", "NO")
                }

                override fun onResponse(call: Call<OverviewModel>, response: Response<OverviewModel>) {
                    Log.d("RESPONSE ${Thread.currentThread().name}", response.body().toString())
                    dataSet.add(response.body())
                }
            })
        }
    }

    private fun getMovieDataTMDB() {
        runBlocking {
            val apiService = MovieApiService.getInstance().create(RetrofitInterface::class.java)
            apiService.getMovieTMDB(generateRandomIdTMDB(),API_KEY).enqueue(object : Callback<TMDBMovie> {
                override fun onFailure(call: Call<TMDBMovie>, t: Throwable) {
                    Log.d("RESPONSE TMDB ${Thread.currentThread().name}", "NO")
                }

                override fun onResponse(call: Call<TMDBMovie>, response: Response<TMDBMovie>) {
                    Log.d("RESPONSE TMDB ${Thread.currentThread().name}", response.body().toString())
                    dataSetTMDB.add(response.body())
                }
            })
        }
    }


    private fun generateRandomId(): String {
        return "tt0" + Random.nextInt(100000, 999999).toString()
    }

    private fun generateRandomIdTMDB(): Int {
        return Random.nextInt(500, 550)
    }

}