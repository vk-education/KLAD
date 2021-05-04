package com.example.finema.ui.tmp

import android.app.Activity
import androidx.navigation.Navigation
import com.example.finema.R
import com.example.finema.repositories.Singleton
import com.example.finema.ui.base.BaseViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class TmpViewModel: BaseViewModel() {

    private val mAuth = Firebase.auth

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
}
