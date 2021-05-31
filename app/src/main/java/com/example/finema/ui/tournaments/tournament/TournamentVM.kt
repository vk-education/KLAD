package com.example.finema.ui.tournaments.tournament

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation.findNavController
import com.example.finema.R
import com.example.finema.api.MoviesRepository
import com.example.finema.database.firebase.FirebaseRepository
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
    private val DBRepository: RoomRepository,
    private val fbRepository: FirebaseRepository = FirebaseRepository()
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

    var title = ""

    init {
        start()
    }


    private fun start() {
        numFilms = AppPreference.getNumOfFilms()
        genreOrCategory()
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
                val genre = AppPreference.getGenreId() ?: "12"
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

    private fun endOfWordGrammar(): String {
        var string = "фильмов"
        when (numFilms) {
            8 -> string = "фильмов"
            16 -> string = "фильмов"
            32 -> string = "фильма"
            64 -> string = "фильма"
            128 -> string = "фильмов"
            256 -> string = "фильма"
        }
        return string
    }

    private fun genreOrCategory() {
        when (AppPreference.getTournamentType()) {
            "GENRE" -> {
                val film = endOfWordGrammar()
                val name = AppPreference.getGenreName()
                title = "$numFilms Лучших $film в жанре $name"
            }
            "CATEGORY" -> {
                title = AppPreference.getCategoryName() ?: " "
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

    private fun insert(movie: Movie) {
        viewModelScope.launch(Dispatchers.Main) {
            DBRepository.insertFavourite(
                makeMovieModel(movie)
            ) {
            }
        }
        if (AppPreference.getGuestOrAuth() == "AUTH") {
            viewModelScope.launch(Dispatchers.Main) {
                fbRepository.insertFirebaseFavouriteFilm(makeMovieModel(movie))
            }
        }
    }

    private fun delete(movie: Movie) {

        viewModelScope.launch(Dispatchers.Main) {
            DBRepository.deleteFavourite(
                makeMovieModel(movie)
            ) {
            }
        }
        if (AppPreference.getGuestOrAuth() == "AUTH"){
            viewModelScope.launch(Dispatchers.Main) {
                fbRepository.deleteFirebaseFavouriteFilm(makeMovieModel(movie))
            }
        }

    }
    private fun makeMovieModel(movie: Movie) =
        MovieModel(
            movie.id.toLong(),
            movie.title,
            POSTER_BASE_URL + movie.posterPath,
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

    companion object {
        const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"
    }
}
