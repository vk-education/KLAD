package com.example.finema

import android.net.Uri
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.finema.databinding.ActivityMainBinding
import com.example.finema.repositories.IAppPreference
import com.example.finema.ui.settings.NotificationService
import com.example.finema.util.APP_ACTIVITY
import com.example.finema.util.downloadAndSetImageUri
import com.google.firebase.auth.FirebaseAuth
import java.util.concurrent.TimeUnit
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val appPreference: IAppPreference by inject()
    private var simpleNotification =
        PeriodicWorkRequestBuilder<NotificationService>(
            NOTIFICATION_REPEAT,
            TimeUnit.HOURS,
            NOTIFICATION_FLEX,
            TimeUnit.HOURS
        )
            .addTag("tag")
            .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        APP_ACTIVITY = this
        appPreference.getPreference()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.topAppBar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }

        binding.navView.getHeaderView(HEADER_VIEW_INDEX).setOnClickListener {
            binding.drawerLayout.close()
            findNavController(R.id.fragment)
                .navigate(R.id.action_global_fragmentProfile)
        }

        binding.navView.setNavigationItemSelectedListener {
            binding.drawerLayout.close()

            when (it.itemId) {
                R.id.lovely ->
                    findNavController(R.id.fragment)
                        .navigate(R.id.action_global_fragmentFavourite)

                R.id.budget ->
                    findNavController(R.id.fragment)
                        .navigate(R.id.action_global_fragmentHigherLower)

                R.id.rating ->
                    findNavController(R.id.fragment)
                        .navigate(R.id.action_global_higherLowerRatingFragment)

                R.id.tournament ->
                    findNavController(R.id.fragment)
                        .navigate(R.id.action_global_fragmentTmp)

                R.id.settings ->
                    findNavController(R.id.fragment)
                        .navigate(R.id.action_global_fragmentSettings)

                R.id.addFav ->
                    findNavController(R.id.fragment)
                        .navigate(R.id.action_global_chooseFavouriteFragment)
            }
            true
        }
    }

    override fun onStart() {
        super.onStart()
        addDestinationChangedListener()
        checkIfUserInited()
    }

    override fun onStop() {
        super.onStop()
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val notifications = sharedPreferences.getBoolean("notifications", true)

        if (notifications) {
            WorkManager.getInstance(this)
                .enqueueUniquePeriodicWork(
                    "notification",
                    ExistingPeriodicWorkPolicy.REPLACE,
                    simpleNotification
                )
        }
    }

    private fun checkIfUserInited() {
        if (!appPreference.getInitUser()) {
            toSignInFragment()
        } else {
            if (FirebaseAuth.getInstance().currentUser?.displayName == null) {
                setPhotoAndNameGuest()
            } else {
                setPhotoAndNameUser()
            }
        }
    }

    private fun addDestinationChangedListener() {
        findNavController(R.id.fragment)
            .addOnDestinationChangedListener { _, destination, _ ->
                if (SCREENS_WITHOUT_DRAWER.contains(destination.id)) {
                    binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
                    binding.topAppBar.visibility = View.GONE
                    binding.appBarCollapse.visibility = View.GONE
                } else {
                    binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNDEFINED)
                    binding.topAppBar.visibility = View.VISIBLE
                    binding.appBarCollapse.visibility = View.VISIBLE
                }

                if (SCREENS_WITH_IMAGE.contains(destination.id)) {
                    binding.imageAppBar.visibility = View.VISIBLE
                } else {
                    binding.imageAppBar.visibility = View.GONE
                    binding.imageAppBar.setImageDrawable(null)
                    binding.topAppBar.title = resources.getString(R.string.app_name)
                }

                when (destination.label) {
                    "Tournament fragment" -> {
                        appPreference.setFragment(destination.label as String)
                    }
                    "Film fragment" -> {
                    }

                    "SigInFragment" -> {
                        appPreference.setFragment(destination.label as String)
                    }

                    else -> {
                        appPreference.setFragment("")
                        Log.d("Destination", destination.label as String)
                    }
                }
            }
    }

    private fun setPhotoAndNameUser() {
        binding.navView
            .getHeaderView(HEADER_VIEW_INDEX)
            .findViewById<TextView>(R.id.nickProfile)
            .text = FirebaseAuth.getInstance().currentUser?.displayName.orEmpty()
        binding.navView
            .getHeaderView(HEADER_VIEW_INDEX)
            .findViewById<ImageView>(R.id.userAvatar)
            .downloadAndSetImageUri(FirebaseAuth.getInstance().currentUser?.photoUrl)
    }

    private fun setPhotoAndNameGuest() {
        binding.navView
            .getHeaderView(HEADER_VIEW_INDEX)
            .findViewById<TextView>(R.id.nickProfile)
            .text = "Гость"
        binding.navView
            .getHeaderView(HEADER_VIEW_INDEX)
            .findViewById<ImageView>(R.id.userAvatar)
            .downloadAndSetImageUri(Uri.parse(DEFAULT_URI))
    }

    private fun toSignInFragment() {
        findNavController(R.id.fragment)
            .navigate(R.id.action_global_signIn)
    }

    companion object {
        private val SCREENS_WITHOUT_DRAWER = listOf(
            R.id.sigInFragment
        )
        private val SCREENS_WITH_IMAGE = listOf(
            R.id.fragmentFilm
        )
        private const val DEFAULT_URI =
            "android.resource://com.example.finema/drawable/default_profile_avatar"
        private const val NOTIFICATION_REPEAT = 5L
        private const val NOTIFICATION_FLEX = 2L
        private const val HEADER_VIEW_INDEX = 0
    }
}
