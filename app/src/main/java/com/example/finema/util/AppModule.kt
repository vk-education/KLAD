package com.example.finema.util

import android.app.Application
import androidx.room.Room
import android.content.Context
import com.example.finema.api.*
import com.example.finema.database.room.*
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.ui.higherlower.HigherLowerViewModel
import com.example.finema.ui.movieDetail.MovieDetailsViewModel
import com.example.finema.ui.signIn.SignInViewModel
import com.example.finema.ui.tmp.TmpViewModel
import com.example.finema.ui.tournaments.TournamentVM
import com.example.finema.ui.tournaments.genres.GenresTournamentVM
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

val viewModelModule: Module = module {

    viewModel<HigherLowerViewModel>()

    viewModel<SignInViewModel>()

    viewModel<TmpViewModel>()

    viewModel<BaseViewModel>()

    viewModel<GenresTournamentVM>()

    viewModel<MovieDetailsViewModel>()

    viewModel<TournamentVM>()
}

val apiModule: Module = module {

    fun provideMoviesApi(retrofit: Retrofit): MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }

    single<MoviesApi> { provideMoviesApi(get<Retrofit>()) }
}

val databaseModule: Module = module {

    fun provideDatabase(application: Application): RoomDataBase {
        return Room.databaseBuilder(application, RoomDataBase::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideRoomDao(database: RoomDataBase): RoomDao {
        return  database.getRoomDao()
    }

    single<RoomDataBase> { provideDatabase(androidApplication()) }
    single<RoomDao> { provideRoomDao(get<RoomDataBase>()) }
}

val repositoryModule: Module = module {

    fun provideMoviesRepository(api: MoviesApi, context: Context, dao : RoomDao): IMoviesRepository {
        return MoviesRepository(api, context, dao)
    }

    single<IMoviesRepository> { provideMoviesRepository(get<MoviesApi>(), androidContext(), get<RoomDao>()) }
}