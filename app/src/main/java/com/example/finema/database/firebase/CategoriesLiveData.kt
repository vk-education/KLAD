package com.example.finema.database.firebase

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.finema.models.databaseModels.CategoryModel
import com.example.finema.util.REF_DATABASE
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class CategoriesLiveData : LiveData<List<CategoryModel>>() {
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
        REF_DATABASE.removeEventListener(listener)
        super.onInactive()
    }

    override fun onActive() {
        REF_DATABASE.addValueEventListener(listener)
        super.onActive()
    }
}
