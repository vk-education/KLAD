package com.example.finema.ui.tournaments

import android.app.Application
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.utlis.REPOSITORY

class TournamentGenresVM(application: Application):BaseViewModel(application) {
    val allGenres = REPOSITORY.allGenres
    fun signOut(){
        REPOSITORY.signOut()
    }
}