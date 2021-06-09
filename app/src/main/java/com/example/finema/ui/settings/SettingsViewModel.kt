package com.example.finema.ui.settings

import com.example.finema.database.DatabaseRepository
import com.example.finema.database.firebase.IFirebaseRepository
import com.example.finema.repositories.Contract
import com.example.finema.ui.base.BaseViewModel

class SettingsViewModel(
    private val dbRepository: DatabaseRepository,
    private val contract: Contract,
    private val fbRepository: IFirebaseRepository

) : BaseViewModel() {
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
