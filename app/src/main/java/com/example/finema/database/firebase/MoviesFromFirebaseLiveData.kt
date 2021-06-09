package com.example.finema.database.firebase

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.finema.models.databaseModels.MovieModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MoviesFromFirebaseLiveData : LiveData<List<MovieModel>>() {

    private val auth = FirebaseAuth.getInstance()
    private val currentId = auth.currentUser?.uid.toString()
    private val reDatabaseUserSaved = FirebaseDatabase
        .getInstance()
        .reference
        .child("user_list")
        .child(currentId)
        .child("saved")

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
        reDatabaseUserSaved.removeEventListener(listener)
        super.onInactive()
    }

    override fun onActive() {
        reDatabaseUserSaved.addValueEventListener(listener)
        super.onActive()
    }
}
