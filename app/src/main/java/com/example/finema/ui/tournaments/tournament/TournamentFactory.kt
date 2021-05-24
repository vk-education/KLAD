package com.example.finema.ui.tournaments.tournament

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.finema.api.MoviesRepository
import java.lang.IllegalArgumentException

//class TournamentFactory(private var apiRepository: MoviesRepository,var genre: String,private var num: Int) : ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(TournamentVM::class.java)){
//            return TournamentVM(apiRepository,genre, num) as T
//        }
//        throw IllegalArgumentException("viewModel class not found")
//    }
//}