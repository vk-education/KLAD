package com.example.finema.ui.tournaments.genres

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.finema.api.MoviesRepository
import com.example.finema.database.DatabaseRepository
import com.example.finema.models.GenreRequest.GenreList
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.database.room.RoomRepository
import com.example.finema.models.movieResponse.Movie
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.AppPreference
import com.example.finema.util.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GenresTournamentVM (
    private val apiRepository: MoviesRepository,
    val DBRepository: DatabaseRepository
) : BaseViewModel() {

    init {
        getGenres {
            AppPreference.setGeneratedGenres(true)
        }
    }

    //TODO Инстант класса


    // TODO Убрать, данные получаются от репозитория

    val genreModel: (String) -> Unit = { genre ->
        getMovies(genre)
    }

    var filmListVM = MutableLiveData<List<Movie>>()
    var genreListVM = MutableLiveData<GenreList>()

    private fun getMovies(genre:String) {
        job = Coroutines.ioThenMan(
            { apiRepository.getMoviesWithGenre(1, genre) },
            { filmListVM.value = it?.movies }
        )
    }

    fun signOut() {
        DBRepository.signOut()
    }

    private fun getGenres(onSuccess:() -> Unit) {
        job = Coroutines.ioThenMan(
            { apiRepository.getGenres() },
            { genreListVM.value = it }
        )
        onSuccess()
    }

    fun insert(genreModel: GenreModel) =
        viewModelScope.launch(Dispatchers.Main) {
            DBRepository.insert(genreModel) {
            }
        }

}
