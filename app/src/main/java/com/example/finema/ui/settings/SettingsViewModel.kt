package com.example.finema.ui.settings

import com.example.finema.database.room.RoomRepository
import com.example.finema.ui.base.BaseViewModel

class SettingsViewModel(
    private val DBRepository: RoomRepository
) : BaseViewModel() {

    suspend fun clearStatistics() {
        DBRepository.deleteAllFavourite {}
        DBRepository.deleteAllTop {}
    }
}