package com.example.finema.ui.tournaments.tournament

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import com.example.finema.R
import com.example.finema.api.MoviesRepository
import com.example.finema.models.movieResponse.Movie
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.APP_ACTIVITY
import com.example.finema.util.Coroutines

class TournamentVM(
    private val apiRepository: MoviesRepository
) : BaseViewModel() {

    var twoFilms = MutableLiveData<List<Movie>>()

    var gotList = MutableLiveData<List<Movie>>()
    var mainList: ArrayList<Movie> = ArrayList()
    var secondList: ArrayList<Movie> = ArrayList()

    private lateinit var el1: Movie
    private lateinit var el2: Movie

    var roundCount = 1

    private val numFilms = 8

    init {
        start()
    }

    fun getMovies(genre: String, onSuccess:() -> Unit) {
        job = Coroutines.ioThenMan(
            { apiRepository.getMoviesWithGenre(1, genre) },
            { gotList.value = it?.movies }
        )
        onSuccess()
    }


    private fun start() {
        getMovies("12"){
            gotList.observe(APP_ACTIVITY,{
                mainList = it.take(numFilms) as ArrayList<Movie>
                updateCards()
            })
        }

    }



    fun itemClick(position: Int) {
        Log.d("testLog","main"+mainList.size.toString())
        Log.d("testLog","second"+secondList.size.toString())
        if (mainList.isEmpty()) {
            if (secondList.isEmpty()) {
                val bundle = Bundle()
                when (position) {
                    0 -> {
                        val filmIdInfo = el1.id.toLong()
                        bundle.putSerializable("filmId", filmIdInfo)
                    }
                    1 -> {
                        val filmIdInfo = el2.id.toLong()
                        bundle.putSerializable("filmId", filmIdInfo)
                    }
                }

                Navigation.findNavController(APP_ACTIVITY, R.id.fragment)
                    .navigate(R.id.action_fragment_tournament_to_fragment_film, bundle)
            } else {
                when (position) {
                    0 -> {
                        secondList.add(el1)
                    }
                    1 -> {
                        secondList.add(el2)
                    }
                }
                mainList.addAll(secondList)
                secondList.clear()
                roundCount+=1
                updateCards()
            }
        } else {
            when (position) {
                0 -> {
                    secondList.add(el1)
                }
                1 -> {
                    secondList.add(el2)
                }
            }
            updateCards()
        }

    }

    private fun updateCards() {
        el1 = mainList.random()
        mainList.remove(el1)
        el2 = mainList.random()
        mainList.remove(el2)
        twoFilms.value = listOf(el1, el2)
    }


}
