package com.example.finema.ui.higherlower

import com.example.finema.api.MoviesApi
import com.example.finema.api.MoviesRepository
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.ui.movieDetail.MovieDetailsViewModel
import com.example.finema.ui.signIn.SignInViewModel
import com.example.finema.ui.tmp.TmpViewModel
import com.example.finema.ui.tournaments.TournamentVM
import com.example.finema.ui.tournaments.genres.GenresTournamentVM
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {
    single { MoviesApi() }

    single{ MoviesRepository( get() ) }

    viewModel<HigherLowerViewModel>()

    viewModel<SignInViewModel>()

    viewModel<TmpViewModel>()

    viewModel<BaseViewModel>()

    viewModel<GenresTournamentVM>()

    viewModel<MovieDetailsViewModel>()

    viewModel<TournamentVM>()

}
