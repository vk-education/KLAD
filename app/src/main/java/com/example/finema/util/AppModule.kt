package com.example.finema.util

import com.example.finema.api.IMoviesRepository
import com.example.finema.api.MoviesApi
import com.example.finema.api.MoviesRepository
import com.example.finema.database.DatabaseRepository
import com.example.finema.database.firebase.FirebaseRepository
import com.example.finema.database.firebase.IFirebaseRepository
import com.example.finema.database.room.RoomDataBase
import com.example.finema.database.room.RoomRepository
import com.example.finema.repositories.AppPreference
import com.example.finema.repositories.Contract
import com.example.finema.repositories.IAppPreference
import com.example.finema.ui.chooseFavourite.ChooseFavouriteViewModel
import com.example.finema.ui.favourite.FavouriteViewModel
import com.example.finema.ui.higherlower.HigherLowerViewModel
import com.example.finema.ui.higherlowerrating.HigherLowerRatingViewModel
import com.example.finema.ui.movieDetail.MovieDetailsViewModel
import com.example.finema.ui.settings.SettingsViewModel
import com.example.finema.ui.signIn.SignInViewModel
import com.example.finema.ui.tmp.TmpViewModel
import com.example.finema.ui.tournaments.categories.CategoryTournamentVM
import com.example.finema.ui.tournaments.genres.GenresTournamentVM
import com.example.finema.ui.tournaments.tournament.TournamentVM
import com.example.finema.ui.userProfile.ProfileViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {

    viewModel { HigherLowerViewModel(get(), get(), get(), get()) }

    viewModel { SignInViewModel(get(), get()) }

    viewModel { TmpViewModel(get(), get(), get()) }

    viewModel { GenresTournamentVM(get(), get(), get()) }

    viewModel { MovieDetailsViewModel(get(), get(), get(), get()) }

    viewModel { TournamentVM(get(), get(), get(), get()) }

    viewModel { CategoryTournamentVM(get(), get()) }

    viewModel { HigherLowerRatingViewModel(get(), get(), get(), get()) }

    viewModel { FavouriteViewModel(get()) }

    viewModel { SettingsViewModel(get(), get(), get(), get()) }

    viewModel { ChooseFavouriteViewModel(get()) }

    viewModel { ProfileViewModel(get()) }
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

    single<IAppPreference> { AppPreference(androidContext()) }

    single<DatabaseRepository> { RoomRepository(get()) }

    single<IMoviesRepository> { MoviesRepository(get()) }

    single<IFirebaseRepository> { FirebaseRepository() }
}
