package com.example.finema.ui.tmp

import android.app.Activity
import android.view.View.INVISIBLE
import androidx.drawerlayout.widget.DrawerLayout
import androidx.drawerlayout.widget.DrawerLayout.LOCK_MODE_LOCKED_CLOSED
import androidx.navigation.Navigation
import com.example.finema.R
import com.example.finema.repositories.Singleton
import com.example.finema.ui.base.BaseViewModel
import com.google.android.material.appbar.MaterialToolbar
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class TmpViewModel: BaseViewModel() {

    private val mAuth = Firebase.auth

    fun logIn(activity: Activity){
        val user = mAuth.currentUser
        if(user != null){
            return
        }else if(!Singleton.signInAsGuest){
            activity.findViewById<DrawerLayout>(R.id.drawer_layout).setDrawerLockMode(LOCK_MODE_LOCKED_CLOSED)
            activity.findViewById<MaterialToolbar>(R.id.topAppBar).visibility = INVISIBLE
            Navigation.findNavController(activity, R.id.fragment)
                .navigate(R.id.action_tmpFragment_to_sigInFragment)
        }
        else{
            return
        }
    }
}