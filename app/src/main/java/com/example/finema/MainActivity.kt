package com.example.finema

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.finema.databinding.ActivityMainBinding
import com.example.finema.ui.settings.NotificationService
import com.example.finema.util.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var simpleNotification = OneTimeWorkRequestBuilder<NotificationService>()
        .addTag("tag")
        .setInitialDelay(5, TimeUnit.SECONDS)
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        APP_ACTIVITY = this
        AppPreference.getPreference(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topAppBar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }

        checkUser()

        binding.navView.getHeaderView(0).setOnClickListener {
            findNavController(R.id.fragment)
                .navigate(R.id.action_global_fragmentProfile)
        }

        binding.navView.setNavigationItemSelectedListener {
            binding.drawerLayout.close()

            when (it.itemId) {

                R.id.budget -> findNavController(R.id.fragment)
                    .navigate(R.id.action_global_fragmentHigherLower)

                R.id.rating -> findNavController(R.id.fragment)
                    .navigate(R.id.action_global_higherLowerRatingFragment)

                R.id.tournament -> findNavController(R.id.fragment)
                    .navigate(R.id.action_global_fragmentTmp)

                R.id.settings -> findNavController(R.id.fragment)
                    .navigate(R.id.action_global_fragmentSettings)
            }

            true
        }
    }


    override fun onStart() {
        super.onStart()

        findNavController(R.id.fragment)
            .addOnDestinationChangedListener { _, destination, _ ->
                if (SCREENS_WITHOUT_DRAWER.contains(destination.id)) {
                    binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
                    binding.topAppBar.visibility = View.GONE
                } else {
                    binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNDEFINED)
                    binding.topAppBar.visibility = View.VISIBLE
                }
            }

        if (!AppPreference.getInitUser()) {
            initDatabase(this, TYPE_ROOM) {
                findNavController(R.id.fragment)
                    .navigate(R.id.action_global_signIn)
            }
        } else {
            initDatabase(this, TYPE_ROOM) {
                Log.d("testLog", "nothing")
            }
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

    private fun checkUser() {
        if (AppPreference.getInitUser()) {
            initDatabase(applicationContext, TYPE_ROOM) {
            }
        }
    }

    private fun initDatabase(context: Context, type: String, onSuccess: () -> Unit) {
        when (type) {
            TYPE_ROOM -> {
                onSuccess()
            }
        }
    }

    companion object {
        private val SCREENS_WITHOUT_DRAWER = listOf(
            R.id.sigInFragment
        )
    }
}
