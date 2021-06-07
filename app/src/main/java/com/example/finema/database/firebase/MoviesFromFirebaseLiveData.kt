package com.example.finema.database.firebase

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.finema.models.databaseModels.MovieModel
import com.example.finema.util.REF_DATABASE_USER_SAVED
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class MoviesFromFirebaseLiveData : LiveData<List<MovieModel>>() {
    private val listener = object : ValueEventListener {
        override fun onCancelled(p0: DatabaseError) {
            Log.d("CategoriesLiveData", p0.message)
        }

        override fun onDataChange(p0: DataSnapshot) {
            value = p0.children.map {
                it.getValue(MovieModel::class.java) ?: MovieModel()
            }
        }
    }

    override fun onInactive() {
        REF_DATABASE_USER_SAVED.removeEventListener(listener)
        super.onInactive()
    }

    override fun onActive() {
        REF_DATABASE_USER_SAVED.addValueEventListener(listener)
        super.onActive()
    }
}
