package com.example.finema.ui.tmp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.finema.api.MoviesRepository
import com.example.finema.database.room.RoomRepository
import com.example.finema.models.GenreRequest.GenreList
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TmpViewModel(
    private val apiRepository: MoviesRepository,
    private val BDRepository: RoomRepository
    ): BaseViewModel() {

    //TODO Аналогичнго с TournamentGenresVM
    var genreListVM = MutableLiveData<GenreList>()

    fun getGenres(onSuccess:() -> Unit){
        job = Coroutines.ioThenMan(
            { apiRepository.getGenres() },
            { genreListVM.value = it }
        )
    }

    fun insert(genreModel: GenreModel, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.Main) {
            BDRepository.insert(genreModel){
                onSuccess()
            }
        }

}
