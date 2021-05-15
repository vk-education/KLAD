package com.example.finema.util

import com.example.finema.api.*
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.ui.higherlower.HigherLowerViewModel
import com.example.finema.ui.movieDetail.MovieDetailsViewModel
import com.example.finema.ui.signIn.SignInViewModel
import com.example.finema.ui.tmp.TmpViewModel
import com.example.finema.ui.tournaments.TournamentVM
import com.example.finema.ui.tournaments.genres.GenresTournamentVM
import com.example.finema.ui.tournaments.TournamentDuoVM
import com.example.finema.ui.tournaments.TournamentGenresVM
import com.google.firebase.auth.FirebaseAuth
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import java.security.Provider

val appModule: Module = module {
    single { MoviesApi() }

    single { MoviesRepository(get()) }

    viewModel<HigherLowerViewModel>()

    viewModel<SignInViewModel>()

    viewModel<TmpViewModel>()

    viewModel<BaseViewModel>()

    viewModel<GenresTournamentVM>()

    viewModel<MovieDetailsViewModel>()

    viewModel<TournamentVM>()

}
