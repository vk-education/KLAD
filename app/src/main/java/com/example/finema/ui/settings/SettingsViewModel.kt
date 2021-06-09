package com.example.finema.ui.settings

import com.example.finema.database.DatabaseRepository
import com.example.finema.database.firebase.IFirebaseRepository
import com.example.finema.repositories.Contract
import com.example.finema.repositories.IAppPreference
import com.example.finema.ui.base.BaseViewModel

class SettingsViewModel(
    private val dbRepository: DatabaseRepository,
    private val contract: Contract,
    private val fbRepository: IFirebaseRepository,
    private val appPreference: IAppPreference

) : BaseViewModel() {
    suspend fun clearAllStatistics() {
        dbRepository.deleteAllFavourite {}
        dbRepository.deleteAllTop {}
    }

    fun clearFireBase() {
        fbRepository.clearFirebaseFavourite()
    }

    fun googleSignOut() {
        appPreference.setInitUser(false)
        appPreference.googleUserSignOut()
        contract.signOut()
    }

    fun getGuestOrAuth(): String? {
        return appPreference.getGuestOrAuth()
    }
}
