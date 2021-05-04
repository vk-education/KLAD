package com.example.finema.ui.tmp

import android.app.Activity
import android.app.Application
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import com.example.finema.R
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.repo.Singleton
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.utlis.APP_ACTIVITY
import com.example.finema.utlis.REPOSITORY
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TmpViewModel(application: Application): BaseViewModel(application) {

    private val mAuth = Firebase.auth
    private val mContext = application
    val allGenres = REPOSITORY.allGenres


    fun logIn(activity: Activity){
        val user = mAuth.currentUser
        if(user != null){
            return
        }else if(!Singleton.signInAsGuest){
            Navigation.findNavController(activity, R.id.fragment)
                    .navigate(R.id.action_tmpFragment_to_sigInFragment)

        }
        else{
            return
        }
    }
    fun insert(genreModel: GenreModel, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.Main) {
            REPOSITORY.insert(genreModel){
                onSuccess()
            }
        }


}
