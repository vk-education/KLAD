package com.example.finema.ui.settings

import com.example.finema.database.firebase.FirebaseRepository
import com.example.finema.database.room.RoomRepository
import com.example.finema.repositories.Contract
import com.example.finema.ui.base.BaseViewModel

class SettingsViewModel(
    private val dbRepository: RoomRepository,
    private val contract: Contract
) : BaseViewModel() {
    private val fbRepository: FirebaseRepository = FirebaseRepository()

    suspend fun clearAllStatistics() {
        dbRepository.deleteAllFavourite {}
        dbRepository.deleteAllTop {}
    }

    fun clearFireBase() {
        fbRepository.clearFirebaseFavourite()
    }

    fun googleSignOut() {
        contract.signOut()
    }
}
