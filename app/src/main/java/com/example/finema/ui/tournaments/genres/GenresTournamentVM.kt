package com.example.finema.ui.tournaments.genres

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.finema.api.MoviesApi
import com.example.finema.api.MoviesRepository
import com.example.finema.models.GenreRequest.GenreList
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.models.movieResponse.Movie
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.Coroutines
import com.example.finema.util.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class GenresTournamentVM (
    private val repository: MoviesRepository
) : BaseViewModel() {

    //TODO Инстант класса
    val allGenres = REPOSITORY.allGenres
    // TODO Убрать, данные получаются от репозитория

    var filmListVM = MutableLiveData<List<Movie>>()
    var genreListVM = MutableLiveData<GenreList>()


    fun getMovies(genre:String){
        job = Coroutines.ioThenMan(
            { repository.getMoviesWithGenre(1, genre) },
            { filmListVM.value = it?.movies }
        )
    }

    fun signOut() {
        REPOSITORY.signOut()
    }

    fun getGenres(onSuccess:() -> Unit){
        job = Coroutines.ioThenMan(
            { repository.getGenres() },
            { genreListVM.value = it }
        )
        onSuccess()
    }

    fun insert(genreModel: GenreModel, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.Main) {
            REPOSITORY.insert(genreModel){
                onSuccess()
            }
        }
}