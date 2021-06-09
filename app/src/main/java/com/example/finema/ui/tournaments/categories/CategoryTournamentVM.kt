package com.example.finema.ui.tournaments.categories

import com.example.finema.database.firebase.IFirebaseRepository
import com.example.finema.repositories.IAppPreference
import com.example.finema.ui.base.BaseViewModel

class CategoryTournamentVM(
    private val fbRepository: IFirebaseRepository,
    private val appPreference: IAppPreference
) : BaseViewModel() {
    val allCategories = fbRepository.allCategories

    init {
        fbRepository.initRefCategory()
    }

    fun setParameters(num: Int, categoryName: String, link: String) {
        appPreference.setNumOfFilms(num)
        appPreference.setCategoryName(categoryName)
        appPreference.setCategoryLink(link.toInt())
    }
}
