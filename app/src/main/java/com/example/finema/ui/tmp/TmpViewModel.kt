package com.example.finema.ui.tmp

import androidx.lifecycle.viewModelScope
import com.example.finema.database.DatabaseRepository
import com.example.finema.database.firebase.IFirebaseRepository
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.APP_ACTIVITY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TmpViewModel(
    private val dbRepository: DatabaseRepository,
    private val fbRepository: IFirebaseRepository
) : BaseViewModel() {

    private val allMovies = fbRepository.allMovies

    init {
        fbRepository.initRefs()
    }

    fun initRoomFromFirebaseToRoom() {
        allMovies.observe(
            APP_ACTIVITY,
            { listMovie ->
                listMovie.map { it.id = it.idFirebase.toLong() }
                for (item in listMovie) {
                    viewModelScope.launch(Dispatchers.Main) {
                        dbRepository.insertFavourite(item) {}
                    }
                }
            }
        )
    }
}
