package com.example.finema.ui.userProfile

import android.net.Uri
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.navigation.Navigation
import com.example.finema.R
import com.example.finema.api.MoviesRepository
import com.example.finema.database.room.RoomRepository
import com.example.finema.models.databaseModels.TopModel
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.APP_ACTIVITY
import com.google.firebase.auth.FirebaseAuth

class ProfileViewModel (
    private val DBRepository: RoomRepository
    ) : BaseViewModel() {

    private val mAuth  = FirebaseAuth.getInstance()
    val topMovies: LiveData<List<TopModel>> = DBRepository.allTop

    fun goDetailsFragment(filmIdInfo: Long) {
        val bundle = Bundle()
        bundle.putSerializable("filmId", filmIdInfo)
        Navigation.findNavController(APP_ACTIVITY, R.id.fragment)
            .navigate(R.id.action_fragment_profile_to_fragment_film, bundle)
    }

    fun getName(): String? {
        return mAuth.currentUser?.displayName
    }

    fun getNumber(): String? {
        return mAuth.currentUser?.phoneNumber
    }

    fun getImage(): Uri? {
        return mAuth.currentUser?.photoUrl
    }
}