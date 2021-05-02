package com.example.finema.ui.higherlower

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.finema.api.ApiRepo
import com.example.finema.models.TMDBMovie
import com.example.finema.ui.base.BaseViewModel

class HigherLowerViewModel: BaseViewModel() {

    private lateinit var mMovieList : MutableLiveData<List<TMDBMovie?>>
    private lateinit var movieList: LiveData<List<TMDBMovie?>>
    private var mRepo : ApiRepo? = null

    fun init(){
        if(mRepo!=null){
            return
        }
        mRepo = ApiRepo().getInstance()!!
        mMovieList = mRepo!!.getApiRepo()
    }

    fun getMovie(): LiveData<List<TMDBMovie?>> {
        movieList = mMovieList
        return movieList
    }

    fun refreshData(){
        if(mRepo!=null){
            mMovieList = mRepo!!.getApiRepo()
        }
    }
}
