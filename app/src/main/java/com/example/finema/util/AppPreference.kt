package com.example.finema.util

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.finema.database.room.RoomRepository
import com.google.firebase.auth.FirebaseAuth

//TODO Сделать репозиторием с интерфейсом
object AppPreference {

    private const val INIT_USER = "initUser"
    private const val INIT_GENRES = "initGenres"
    private const val NAME_PREF = "preference"

    private val googleUser: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var mPreferences: SharedPreferences

    //TODO такого не должно быть, преференсы должны исполььзоваться только здесь
    fun getPreference(context: Context):SharedPreferences{
        mPreferences = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE)
        return mPreferences
    }

    fun setInitUser(init:Boolean) {
        mPreferences.edit()
            .putBoolean(INIT_USER, init)
            .apply()
    }

    fun  getInitUser():Boolean {
        return mPreferences.getBoolean(INIT_USER,false)
    }

    fun getGeneratedGenres(): Boolean {
        return mPreferences.getBoolean(INIT_GENRES,false)
    }

    fun setGeneratedGenres(init: Boolean) {
        mPreferences.edit()
            .putBoolean(INIT_GENRES,init)
            .apply()
    }

    fun googleUserSignOut() {
        googleUser.signOut()
        Log.d("OJOF", googleUser.currentUser?.displayName.orEmpty())
    }


}