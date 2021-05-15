package com.example.finema.ui.signIn

import android.content.Context
import com.example.finema.database.room.RoomDataBase
import com.example.finema.database.room.RoomRepository
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.REPOSITORY
import com.example.finema.util.TYPE_ROOM

class SignInViewModel(
): BaseViewModel() {

    //TODO я ничего не понял, Дима объясни
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