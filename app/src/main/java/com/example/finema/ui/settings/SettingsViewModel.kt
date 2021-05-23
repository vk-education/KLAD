package com.example.finema.ui.settings

import androidx.lifecycle.LiveData
import androidx.preference.PreferenceFragmentCompat
import com.example.finema.database.room.RoomRepository
import com.example.finema.models.databaseModels.MovieModel
import com.example.finema.ui.base.BaseViewModel

class SettingsViewModel(
    private val DBRepository: RoomRepository
): BaseViewModel() {

    suspend fun clearStatistics() {
        DBRepository.deleteFavourite {
        }
    }
}