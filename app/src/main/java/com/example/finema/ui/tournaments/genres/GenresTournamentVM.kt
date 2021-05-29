package com.example.finema.ui.tournaments.genres

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.finema.api.MoviesRepository
import com.example.finema.database.room.RoomRepository
import com.example.finema.models.GenreRequest.GenreList
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GenresTournamentVM(
    private val apiRepository: MoviesRepository,
    private val DBRepository: RoomRepository
) : BaseViewModel() {


    // TODO Убрать, данные получаются от репозитория
    val allGenres: LiveData<List<GenreModel>>
        get() {
            return DBRepository.allGenres
        }

    var genreListVM = MutableLiveData<GenreList>()

    fun checkDatabaseNotEmpty(): Boolean {
        // TODO не работает, так как вызов асинхронный
        return allGenres.value != null
    }

    fun signOut() {
        DBRepository.signOut()
    }

    fun getGenres() {
        job = Coroutines.ioThenMan(
            { apiRepository.getGenres() },
            { genreListVM.value = it }
        )
    }

    fun insert(genreModel: GenreModel) =
        viewModelScope.launch(Dispatchers.Main) {
            DBRepository.insert(genreModel) {
            }
        }
}