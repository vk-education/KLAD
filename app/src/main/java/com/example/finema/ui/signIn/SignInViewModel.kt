package com.example.finema.ui.signIn

import android.app.Application
import com.example.finema.database.room.RoomDataBase
import com.example.finema.database.room.RoomRepository
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.REPOSITORY
import com.example.finema.util.TYPE_ROOM
import com.google.firebase.auth.FirebaseAuth

class SignInViewModel(application: Application): BaseViewModel(application) {
    private val mContext = application

    //TODO я ничего не понял, Дима объясни
    fun initDatabase(type:String, onSuccess:() -> Unit){
        when (type){
            TYPE_ROOM -> {
                val dao = RoomDataBase.getInstance(mContext).getRoomDao()
                REPOSITORY = RoomRepository(dao)
                onSuccess()
            }
        }
    }

}