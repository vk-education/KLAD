package com.example.finema.ui.settings

import com.example.finema.database.firebase.FirebaseRepository
import android.content.Context
import com.example.finema.database.room.RoomRepository
import com.example.finema.ui.base.BaseViewModel
import java.io.File

class SettingsViewModel(
    private val DBRepository: RoomRepository
) : BaseViewModel() {
    private val fbRepository: FirebaseRepository = FirebaseRepository()

    suspend fun clearStatistics() {
        DBRepository.deleteAllFavourite {}
        DBRepository.deleteAllTop {}
        fbRepository.clearFirebaseFavourite()
    }

    fun deleteCache(context: Context) {
        try {
            val dir: File = context.cacheDir
            deleteDir(dir)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun deleteDir(dir: File?): Boolean {
        return if (dir != null && dir.isDirectory) {
            val children: Array<String> = dir.list()
            for (i in children.indices) {
                val success = deleteDir(File(dir, children[i]))
                if (!success) {
                    return false
                }
            }
            dir.delete()
        } else if (dir != null && dir.isFile()) {
            dir.delete()
        } else {
            false
        }
    }

}