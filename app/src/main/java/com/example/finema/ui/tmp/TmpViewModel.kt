package com.example.finema.ui.tmp

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.finema.api.MoviesRepository
import com.example.finema.api.MoviesApi
import com.example.finema.database.room.RoomDataBase
import com.example.finema.database.room.RoomRepository
import com.example.finema.models.GenreRequest.GenreList
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.Coroutines
import com.example.finema.util.REPOSITORY
import com.example.finema.util.TYPE_ROOM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TmpViewModel(
): BaseViewModel() {

    //TODO Аналогичнго с TournamentGenresVM
    private val apiTmp = MoviesApi()
    private val repository= MoviesRepository(apiTmp)
    var genreListVM = MutableLiveData<GenreList>()

    fun getGenres(onSuccess:() -> Unit){
        job = Coroutines.ioThenMan(
            { repository.getGenres() },
            { genreListVM.value = it }
        )
    }

    fun insert(genreModel: GenreModel, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.Main) {
            REPOSITORY.insert(genreModel){
                onSuccess()
            }
        }

    fun initDatabase(context: Context, type:String, onSuccess:() -> Unit){
        when (type){
            TYPE_ROOM -> {
                val dao = RoomDataBase.getInstance(context).getRoomDao()
                REPOSITORY = RoomRepository(dao)
                onSuccess()
            }
        }
    }

}
