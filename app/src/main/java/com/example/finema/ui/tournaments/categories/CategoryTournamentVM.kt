package com.example.finema.ui.tournaments.categories

import com.example.finema.database.firebase.FirebaseRepository
import com.example.finema.ui.base.BaseViewModel

class CategoryTournamentVM(
) : BaseViewModel() {
    private val fbRepository: FirebaseRepository = FirebaseRepository()
    val allCategories = fbRepository.allCategories

    init {
        fbRepository.initRefCategory()
    }
}
