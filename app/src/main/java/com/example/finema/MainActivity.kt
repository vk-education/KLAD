package com.example.finema

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.finema.databinding.ActivityMainBinding
import com.example.finema.ui.higherlower.appModule
import com.example.finema.ui.settings.NotificationService
import com.example.finema.util.APP_ACTIVITY
import com.example.finema.util.AppPreference
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import java.util.concurrent.TimeUnit


//TODO добавить по аналогии
// findNavController(R.id.fragment_container)
//                    .addOnDestinationChangedListener { _, destination, _ ->
//                        if(SCREENS_WITHOUT_BOTTOM_BAR.contains(destination.id))
//                            binding.bottomBar.visibility = GONE
//                        else
//                            binding.bottomBar.visibility = VISIBLE
//                    }
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    var simpleNotification = OneTimeWorkRequestBuilder<NotificationService>()
        .addTag("tag")
        .setInitialDelay(5, TimeUnit.SECONDS)
        .build()


    private lateinit var service: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        APP_ACTIVITY = this
        AppPreference.getPreference(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topAppBar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }

        startKoin {
            androidContext(this@MainActivity)
            modules(
                appModule
            )
        }

        binding.navView.setNavigationItemSelectedListener {
            binding.drawerLayout.close()

            when (it.itemId) {

                R.id.budget -> Navigation.findNavController(this, R.id.fragment)
                    .navigate(R.id.action_global_fragmentHigherLower)

                R.id.tournament -> Navigation.findNavController(this, R.id.fragment)
                    .navigate(R.id.action_global_fragmentTmp)

                R.id.settings -> Navigation.findNavController(this, R.id.fragment)
                    .navigate(R.id.action_global_fragmentSettings)
            }

            true
        }
    }

    override fun onStop() {
        super.onStop()
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val notifications = sharedPreferences.getBoolean("notifications", true)

        if (notifications) {
            WorkManager.getInstance(this)
                .beginUniqueWork("notification", ExistingWorkPolicy.REPLACE, simpleNotification)
                .enqueue()
        }
    }
}