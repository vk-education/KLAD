package com.example.finema.database.firebase

import androidx.lifecycle.LiveData
import com.example.finema.models.databaseModels.CategoryModel
import com.example.finema.models.databaseModels.MovieModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FirebaseRepository(
    override val firebaseDatabase: FirebaseDatabase
) : IFirebaseRepository {
    override val allCategories: LiveData<List<CategoryModel>> = CategoriesLiveData()
    override val allMovies: LiveData<List<MovieModel>> = MoviesFromFirebaseLiveData()

    private val auth = FirebaseAuth.getInstance()
    private val databaseReference = firebaseDatabase.reference
    private lateinit var reDatabase: DatabaseReference
    private lateinit var reDatabaseUser: DatabaseReference
    private lateinit var reDatabaseUserSaved: DatabaseReference

    override fun initRefCategory() {
        reDatabase = databaseReference
            .child("category")
    }

    override fun initRefs() {

        val currentId = auth.currentUser?.uid.toString()
        reDatabaseUser = databaseReference
            .child("user_list")
            .child(currentId)

        reDatabaseUserSaved = reDatabaseUser.child("saved")
    }

    override fun insertFirebaseFavouriteFilm(movieModel: MovieModel) {

        val fId = "idFirebase"
        val fTitle = "title"
        val fImageUrl = "imageUrl"
        val fAbout = "about"
        val fRating = "rating"

        val mapMovie = hashMapOf<String, Any>()
        mapMovie[fId] = movieModel.id.toString()
        mapMovie[fTitle] = movieModel.title
        mapMovie[fImageUrl] = movieModel.imageUrl.toString()
        mapMovie[fAbout] = movieModel.about
        mapMovie[fRating] = movieModel.rating

        reDatabaseUserSaved.child(movieModel.id.toString())
            .updateChildren(mapMovie)
    }

    override fun deleteFirebaseFavouriteFilm(movieModel: MovieModel) {
        reDatabaseUserSaved.child(movieModel.id.toString()).removeValue()
    }

    override fun clearFirebaseFavourite() {
        reDatabaseUserSaved.removeValue()
    }
}
