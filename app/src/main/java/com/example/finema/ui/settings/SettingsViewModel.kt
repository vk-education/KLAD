package com.example.finema.ui.settings

import com.example.finema.database.firebase.FirebaseRepository
import com.example.finema.database.room.RoomRepository
import com.example.finema.ui.base.BaseViewModel

class SettingsViewModel(
    private val DBRepository: RoomRepository
) : BaseViewModel() {
    private val fbRepository: FirebaseRepository = FirebaseRepository()

    suspend fun clearStatistics() {
        DBRepository.deleteAllFavourite {}
        DBRepository.deleteAllTop {}
        fbRepository.clearFirebaseFavourite()
    }
}