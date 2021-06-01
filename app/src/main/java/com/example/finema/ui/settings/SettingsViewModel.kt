package com.example.finema.ui.settings

import com.example.finema.database.firebase.FirebaseRepository
import android.content.Context
import com.example.finema.database.room.RoomRepository
import com.example.finema.repositories.Contract
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.AppPreference
import java.io.File

class SettingsViewModel(
    private val DBRepository: RoomRepository,
    private val contract: Contract
) : BaseViewModel() {
    private val fbRepository: FirebaseRepository = FirebaseRepository()

    suspend fun clearAllStatistics() {
        DBRepository.deleteAllFavourite {}
        DBRepository.deleteAllTop {}
    }

    fun clearFireBase() {
        fbRepository.clearFirebaseFavourite()
    }

    fun googleSignOut() {
        contract.signOut()
    }

}