package com.example.finema

import android.app.Application
import com.example.finema.util.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MovieApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MovieApplication)
            androidFileProperties()
            modules( listOf(
                apiModule,
                databaseModule,
                repositoryModule,
                extraModule,
                viewModelModule
                )
            )
        }

    }
}