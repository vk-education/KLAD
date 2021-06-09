package com.example.finema.ui.tournaments.tournament

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation.findNavController
import com.example.finema.R
import com.example.finema.api.IMoviesRepository
import com.example.finema.database.DatabaseRepository
import com.example.finema.database.firebase.IFirebaseRepository
import com.example.finema.models.databaseModels.MovieModel
import com.example.finema.models.movieResponse.Movie
import com.example.finema.repositories.IAppPreference
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.APP_ACTIVITY
import com.example.finema.util.Coroutines
import kotlin.math.floor
import kotlin.math.log
import kotlin.math.pow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TournamentVM(
    private val apiRepository: IMoviesRepository,
    private val dbRepository: DatabaseRepository,
    private val fbRepository: IFirebaseRepository,
    private val appPreference: IAppPreference
) : BaseViewModel() {

    val favouriteMovies: LiveData<List<MovieModel>> = dbRepository.allFavourites

    var twoFilms = MutableLiveData<List<Movie>>()
    var loopNum: Int = ONE_LOOP
    var flag: Int = FLAG_DEFAULT
    var gotList = MutableLiveData<List<Movie>>()
    var mainList: ArrayList<Movie> = ArrayList()
    var secondList: ArrayList<Movie> = ArrayList()

    private lateinit var el1: Movie
    private lateinit var el2: Movie

    var roundCount = ROUND_COUNT_START

    var numFilms = PRESSED_EIGHT_MOVIES

    var title = TITLE_DEFAULT

    init {
        start()
    }

    private fun start() {
        numFilms = appPreference.getNumOfFilms()
        genreOrCategory()
        setLoopNum()
        getMovies {
            gotList.observe(
                APP_ACTIVITY,
                {
                    numFilms = checkLessNum(it, numFilms)
                    mainList.addAll(it)
                    flag += 1

                    if (flag == loopNum) {
                        mainList = mainList.take(numFilms) as ArrayList<Movie>
                        updateCards()
                    }
                }
            )
        }
    }

    private fun getMovies(onSuccess: () -> Unit) {
        when (appPreference.getTournamentType()) {
            "GENRE" -> {
                val genre = appPreference.getGenreId() ?: GENRE_ID_DEFAULT
                for (page in 1..loopNum) {
                    job = Coroutines.ioThenMan(
                        { apiRepository.getMoviesWithGenre(page, genre) },
                        { gotList.value = it?.movies }
                    )
                }
            }
            "CATEGORY" -> {
                val categoryLink = appPreference.getCategoryLink()
                for (page in 1..loopNum) {
                    job = Coroutines.ioThenMan(
                        { apiRepository.getMovieFromList(categoryLink) },
                        { gotList.value = it?.movies }
                    )
                }
            }
        }
        onSuccess()
    }

    fun itemClick(position: Int) {
        (if (position == 0) el1 else el2)
            .let {
                if (mainList.isEmpty()) {
                    if (secondList.isEmpty()) {
                        val filmIdInfo = it.id.toLong()
                        goNextFragment(filmIdInfo)
                    } else {
                        secondList.add(it)
                        secondListToMainList()
                        updateCards()
                    }
                } else {
                    secondList.add(it)
                    updateCards()
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
        var string = FILM_DECLENSION
        when (numFilms) {
            PRESSED_EIGHT_MOVIES -> string = "фильмов"
            PRESSED_SIXTEEN_MOVIES -> string = "фильмов"
            PRESSED_THIRTY_TWO_MOVIES -> string = "фильма"
            PRESSED_SIXTY_FOUR_MOVIES -> string = "фильма"
            PRESSED_ONE_HUNDRED_AND_TWENTY_EIGHT_MOVIES -> string = "фильмов"
            PRESSED_TWO_HUNDRED_AND_FIFTY_SIX_MOVIES -> string = "фильма"
        }
        return string
    }

    private fun genreOrCategory() {
        when (appPreference.getTournamentType()) {
            "GENRE" -> {
                val film = endOfWordGrammar()
                val name = appPreference.getGenreName()
                title = "$numFilms Лучших $film в жанре $name"
            }
            "CATEGORY" -> {
                title = appPreference.getCategoryName() ?: " "
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
            dbRepository.insertFavourite(
                makeMovieModel(movie)
            ) {
            }
        }
        if (appPreference.getGuestOrAuth() == "AUTH") {
            fbRepository.insertFirebaseFavouriteFilm(makeMovieModel(movie))
        }
    }

    private fun delete(movie: Movie) {
        viewModelScope.launch(Dispatchers.Main) {
            dbRepository.deleteFavourite(
                makeMovieModel(movie)
            ) {
            }
            if (appPreference.getGuestOrAuth() == "AUTH") {
                fbRepository.deleteFirebaseFavouriteFilm(makeMovieModel(movie))
            }
        }
    }

    private fun makeMovieModel(movie: Movie) =
        MovieModel(
            movie.id.toLong(),
            movie.title,
            movie.originalTitle,
            POSTER_BASE_URL + movie.posterPath,
            movie.overview,
            null,
            movie.voteAverage.toString(),
            null
        )

    private fun setLoopNum() {
        when (numFilms) {
            PRESSED_EIGHT_MOVIES or PRESSED_SIXTEEN_MOVIES -> {
                loopNum = ONE_LOOP
            }
            PRESSED_THIRTY_TWO_MOVIES -> {
                loopNum = TWO_LOOP
            }
            PRESSED_SIXTY_FOUR_MOVIES -> {
                loopNum = FOUR_LOOP
            }
            PRESSED_ONE_HUNDRED_AND_TWENTY_EIGHT_MOVIES -> {
                loopNum = SEVEN_LOOP
            }
            PRESSED_TWO_HUNDRED_AND_FIFTY_SIX_MOVIES -> {
                loopNum = THIRTEEN_LOOP
            }
        }
    }

    fun returnDesc(index: Int): String {
        return when (index) {
            0 -> {
                el1.overview
            }
            1 -> {
                el2.overview
            }
            else -> ""
        }
    }

    private fun checkLessNum(list: List<Movie>, num: Int): Int {
        /* Если нажали на 32 фильма, а их всего 20, то мы округляем вниз число 20 до 16. */
        var variable = num
        if (list.size < num) {
            variable = 2.0.pow(floor(log(list.size.toDouble(), 2.0))).toInt()
        }
        return variable
    }

    companion object {
        const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"
        const val PRESSED_EIGHT_MOVIES = 8
        const val PRESSED_SIXTEEN_MOVIES = 16
        const val PRESSED_THIRTY_TWO_MOVIES = 32
        const val PRESSED_SIXTY_FOUR_MOVIES = 64
        const val PRESSED_ONE_HUNDRED_AND_TWENTY_EIGHT_MOVIES = 128
        const val PRESSED_TWO_HUNDRED_AND_FIFTY_SIX_MOVIES = 256
        const val ROUND_COUNT_START = 1
        const val ONE_LOOP = 1
        const val TWO_LOOP = 2
        const val FOUR_LOOP = 4
        const val SEVEN_LOOP = 7
        const val THIRTEEN_LOOP = 13
        const val FLAG_DEFAULT = 0
        const val TITLE_DEFAULT = ""
        const val GENRE_ID_DEFAULT = "12"
        const val FILM_DECLENSION = "фильмов"
    }
}
