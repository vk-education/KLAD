package com.example.finema.database.firebase

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.finema.models.databaseModels.CategoryModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CategoriesLiveData : LiveData<List<CategoryModel>>() {
    private val refDatabaseCategory = FirebaseDatabase
        .getInstance()
        .reference
        .child("category")

    private val listener = object : ValueEventListener {

        override fun onDataChange(p0: DataSnapshot) {
            value = p0.children.map {
                it.getValue(CategoryModel::class.java) ?: CategoryModel()
            }
        }

        override fun onCancelled(error: DatabaseError) {
            Log.d("CategoriesLiveData", error.message)
        }
    }

    override fun onInactive() {
        refDatabaseCategory.removeEventListener(listener)
        super.onInactive()
    }

    override fun onActive() {
        refDatabaseCategory.addValueEventListener(listener)
        super.onActive()
    }
}
