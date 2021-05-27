package com.example.finema.util

import com.example.finema.api.*
import com.example.finema.database.room.*
import com.example.finema.repositories.Contract
import com.example.finema.ui.chooseFavourite.ChooseFavouriteViewModel
import com.example.finema.ui.chooseFavourite.MoviePagingSource
import com.example.finema.ui.favourite.FavouriteViewModel
import com.example.finema.ui.higherlower.HigherLowerViewModel
import com.example.finema.ui.higherlowerrating.HigherLowerRatingViewModel
import com.example.finema.ui.movieDetail.MovieDetailsViewModel
import com.example.finema.ui.settings.SettingsViewModel
import com.example.finema.ui.signIn.SignInViewModel
import com.example.finema.ui.tmp.TmpViewModel
import com.example.finema.ui.tournaments.tournament.TournamentVM
import com.example.finema.ui.tournaments.genres.GenresTournamentVM
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {

    viewModel { HigherLowerViewModel(get()) }

    viewModel { SignInViewModel(get()) }

    viewModel { TmpViewModel() }

    viewModel { GenresTournamentVM(get(), get()) }

    viewModel { MovieDetailsViewModel(get(), get()) }

    viewModel { TournamentVM(get(), get()) }

    viewModel { HigherLowerRatingViewModel(get(), get()) }

    viewModel { FavouriteViewModel(get()) }

    viewModel { SettingsViewModel(get()) }

    viewModel { ChooseFavouriteViewModel(get()) }
}

val apiModule: Module = module {

    single { MoviesApi() }
}

val databaseModule: Module = module {

    single { RoomDataBase.getInstance(androidContext()) }

    single { RoomDataBase.getInstance(androidContext()).getRoomDao() }
}

val repositoryModule: Module = module {

    single { Contract() }

    single { RoomRepository(get()) }

    single { MoviesRepository(get(), get(), androidContext()) }
}
