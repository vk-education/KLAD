package com.example.finema.ui.tournaments.genres

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.finema.api.MoviesApi
import com.example.finema.api.MoviesRepository
import com.example.finema.database.DatabaseRepository
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.models.movieResponse.Movie
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.Coroutines
import com.example.finema.util.REPOSITORY
import kotlinx.coroutines.Job

class GenresTournamentVM (
    private val apiRepository: MoviesRepository,
    private val DBRepository: DatabaseRepository
) : BaseViewModel() {

    //TODO Инстант класса
    val allGenres: LiveData<List<GenreModel>> = DBRepository.allGenres
    // TODO Убрать, данные получаются от репозитория

    var filmListVM = MutableLiveData<List<Movie>>()

    fun getMovies(genre:String){
        job = Coroutines.ioThenMan(
            { apiRepository.getMoviesWithGenre(1, genre) },
            { filmListVM.value = it?.movies }
        )
    }

    fun signOut() {
        DBRepository.signOut()
    }
}