package com.example.finema.ui.tournaments.genres

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.finema.api.IMoviesRepository
import com.example.finema.database.DatabaseRepository
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.models.genreRequest.GenreList
import com.example.finema.repositories.IAppPreference
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GenresTournamentVM(
    private val apiRepository: IMoviesRepository,
    private val dbRepository: DatabaseRepository,
    private val appPreference: IAppPreference
) : BaseViewModel() {

    val allGenres: LiveData<List<GenreModel>>
        get() {
            return dbRepository.allGenres
        }

    var genreListVM = MutableLiveData<GenreList>()

    fun checkDatabaseNotEmpty(): Boolean {
        // TODO не работает, так как вызов асинхронный
        return allGenres.value != null
    }

    fun signOut() {
        dbRepository.signOut()
    }

    fun getGenres() {
        job = Coroutines.ioThenMan(
            { apiRepository.getGenres() },
            { genreListVM.value = it }
        )
    }

    fun insert(genreModel: GenreModel) =
        viewModelScope.launch(Dispatchers.Main) {
            dbRepository.insert(genreModel) {
            }
        }

    fun setParameters(num: Int, genreName: String, genreId: String) {
        appPreference.setNumOfFilms(num)
        appPreference.setGenreName(genreName)
        appPreference.setGenre(genreId)
    }
}
