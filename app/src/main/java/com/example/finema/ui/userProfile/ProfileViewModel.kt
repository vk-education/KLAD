package com.example.finema.ui.userProfile

import android.net.Uri
import androidx.lifecycle.LiveData
import com.example.finema.database.room.RoomRepository
import com.example.finema.models.databaseModels.TopModel
import com.example.finema.ui.base.BaseViewModel
import com.google.firebase.auth.FirebaseAuth

class ProfileViewModel(
    private val dbRepository: RoomRepository
) : BaseViewModel() {

    private val mAuth = FirebaseAuth.getInstance()
    val topMovies: LiveData<List<TopModel>> = dbRepository.allTop

    fun getName(): String? {
        return if (mAuth.currentUser?.displayName == null) {
            "Гость"
        } else {
            mAuth.currentUser?.displayName
        }
    }

    fun getNumber(): String? {
        return if (mAuth.currentUser?.phoneNumber == null) {
            " "
        } else {
            mAuth.currentUser?.phoneNumber
        }
    }

    fun getImage(): Uri? {

        return if (mAuth.currentUser?.photoUrl == null) {
            Uri.parse("android.resource://com.example.finema/drawable/default_profile_avatar")
        } else {
            mAuth.currentUser?.photoUrl
        }
    }
}
