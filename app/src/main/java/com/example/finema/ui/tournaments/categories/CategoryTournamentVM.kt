package com.example.finema.ui.tournaments.categories

import com.example.finema.database.firebase.IFirebaseRepository
import com.example.finema.ui.base.BaseViewModel

class CategoryTournamentVM(
    private val fbRepository: IFirebaseRepository
) : BaseViewModel() {
    val allCategories = fbRepository.allCategories

    init {
        fbRepository.initRefCategory()
    }
}
