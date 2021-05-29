package com.example.finema.ui.tournaments.tournament

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation.findNavController
import com.example.finema.R
import com.example.finema.api.MoviesRepository
import com.example.finema.database.room.RoomRepository
import com.example.finema.models.databaseModels.MovieModel
import com.example.finema.models.movieResponse.Movie
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.APP_ACTIVITY
import com.example.finema.util.AppPreference
import com.example.finema.util.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TournamentVM(
    private val apiRepository: MoviesRepository,
    private val DBRepository: RoomRepository
) : BaseViewModel() {

    var twoFilms = MutableLiveData<List<Movie>>()
    var loopNum: Int = 1
    var flag: Int = 0
    var gotList = MutableLiveData<List<Movie>>()
    var mainList: ArrayList<Movie> = ArrayList()
    var secondList: ArrayList<Movie> = ArrayList()

    private lateinit var el1: Movie
    private lateinit var el2: Movie

    var roundCount = 1

    var numFilms = 8

    init {
        start()
    }


    private fun start() {
        numFilms = AppPreference.getNumOfFilms()
        setLoopNum()
        getMovies {
            gotList.observe(APP_ACTIVITY, {
                mainList.addAll(it)

                if (flag == loopNum) {
                    mainList = mainList.take(numFilms) as ArrayList<Movie>
                    updateCards()
                }
            })
        }
    }

    private fun getMovies(onSuccess: () -> Unit) {
        when (AppPreference.getTournamentType()) {
            "GENRE" -> {
                val genre = AppPreference.getGenre() ?: "12"
                for (page in 1..loopNum) {
                    job = Coroutines.ioThenMan(
                        { apiRepository.getMoviesWithGenre(page, genre) },
                        { gotList.value = it?.movies }
                    )
                    flag += 1
                }
            }
            "CATEGORY" -> {
                val categoryLink = AppPreference.getCategoryLink() ?: 1
                for (page in 1..loopNum) {
                    job = Coroutines.ioThenMan(
                        { apiRepository.getMovieFromList(categoryLink) },
                        { gotList.value = it?.movies }
                    )
                    flag += 1
                }
            }
        }
        onSuccess()
    }


    fun itemClick(position: Int) {
        when (position) {
            0 -> {
                if (mainList.isEmpty()) {
                    if (secondList.isEmpty()) {
                        val filmIdInfo = el1.id.toLong()
                        goNextFragment(filmIdInfo)
                    } else {
                        secondList.add(el1)
                        secondListToMainList()
                        updateCards()
                    }
                } else {
                    secondList.add(el1)
                    updateCards()
                }
            }
            1 -> {
                if (mainList.isEmpty()) {
                    if (secondList.isEmpty()) {
                        val filmIdInfo = el2.id.toLong()
                        goNextFragment(filmIdInfo)
                    } else {
                        secondList.add(el2)
                        secondListToMainList()
                        updateCards()
                    }
                } else {
                    secondList.add(el2)
                    updateCards()
                }
            }
        }
    }

    private fun secondListToMainList() {
        mainList.addAll(secondList)
        secondList.clear()
        roundCount += 1
    }

    private fun goNextFragment(filmIdInfo: Long) {
        val bundle = Bundle()
        bundle.putSerializable("filmId", filmIdInfo)
        findNavController(APP_ACTIVITY, R.id.fragment)
            .navigate(R.id.action_fragment_tournament_to_fragment_film, bundle)
    }

    private fun updateCards() {
        el1 = mainList.random()
        mainList.remove(el1)
        el2 = mainList.random()
        mainList.remove(el2)
        twoFilms.value = listOf(el1, el2)
    }

    fun addToFav(position: Int) {
        when (position) {
            0 -> {
                insert(el1)
            }
            1 -> {
                insert(el2)
            }
        }
    }

    fun removeFromFav(position: Int) {
        when (position) {
            0 -> {
                delete(el1)
            }
            1 -> {
                delete(el2)
            }
        }
    }

    private fun insert(movie: Movie) =
        viewModelScope.launch(Dispatchers.Main) {
            DBRepository.insertFavourite(
                makeMovieModel(movie)
            ) {
            }
        }

    private fun delete(movie: Movie) =
        viewModelScope.launch(Dispatchers.Main) {
            DBRepository.deleteFavourite(
                makeMovieModel(movie)
            ) {
            }
        }

    private fun makeMovieModel(movie: Movie) =
        MovieModel(
            movie.id.toLong(),
            movie.title,
            null,
            movie.overview,
            null,
            movie.voteAverage.toString(),
            null
        )

    private fun setLoopNum() {
        when (numFilms) {
            8 or 16 -> {
                loopNum = 1
            }
            32 -> {
                loopNum = 2
            }
            64 -> {
                loopNum = 4
            }
            128 -> {
                loopNum = 7
            }
            256 -> {
                loopNum = 13
            }
        }
    }
}
