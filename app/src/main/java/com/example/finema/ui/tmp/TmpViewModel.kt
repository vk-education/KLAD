package com.example.finema.ui.tmp

import android.app.Activity
import android.app.Application
import android.view.View.INVISIBLE
import androidx.drawerlayout.widget.DrawerLayout
import androidx.drawerlayout.widget.DrawerLayout.LOCK_MODE_LOCKED_CLOSED
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import com.example.finema.R
import com.example.finema.api.MoviesRepository
import com.example.finema.api.MoviesApi
import com.example.finema.models.GenreRequest.GenreList
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.repositories.Singleton
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.Coroutines
import com.example.finema.util.REPOSITORY
import com.google.android.material.appbar.MaterialToolbar
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TmpViewModel(application: Application): BaseViewModel(application) {

    //TODO убрать в Base
    private lateinit var job: Job

    //TODO Аналогичнго с TournamentGenresVM
    private val apiTmp = MoviesApi()
    private val repository= MoviesRepository(apiTmp)
    var genreListVM = MutableLiveData<GenreList>()

    fun getGenres(){
        job = Coroutines.ioThenMan(
            { repository.getGenres() },
            { genreListVM.value = it }
        )
    }

    //TODO убрать в Base
    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }

    fun insert(genreModel: GenreModel, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.Main) {
            REPOSITORY.insert(genreModel){
                onSuccess()
            }
        }


}
