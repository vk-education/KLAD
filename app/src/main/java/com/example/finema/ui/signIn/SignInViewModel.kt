package com.example.finema.ui.signIn

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.example.finema.database.DatabaseRepository
import com.example.finema.database.room.RoomDataBase
import com.example.finema.database.room.RoomRepository
import com.example.finema.models.movieResponse.MovieResponse
import com.example.finema.repositories.Contract
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.TYPE_ROOM
import com.google.firebase.auth.FirebaseAuth
import org.koin.androidx.compose.get

class SignInViewModel(
    val contract: Contract
): BaseViewModel() {

    val mAuth  = FirebaseAuth.getInstance()

    init  {
        contract.setName("")
    }

}
