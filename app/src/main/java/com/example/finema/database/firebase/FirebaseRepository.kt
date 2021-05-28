package com.example.finema.database.firebase

import androidx.lifecycle.LiveData
import com.example.finema.models.databaseModels.CategoryModel
import com.example.finema.util.REF_DATABASE
import com.google.firebase.database.FirebaseDatabase

class FirebaseRepository {
    val allCategories: LiveData<List<CategoryModel>> = CategoriesLiveData()
    fun initRefs() {
        REF_DATABASE = FirebaseDatabase.getInstance().reference
            .child("category")
    }


}