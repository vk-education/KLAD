package com.example.finema.ui.settings


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.example.finema.R
import com.example.finema.database.room.RoomRepository
import com.example.finema.util.AppPreference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.getViewModel


class SetFragment: PreferenceFragmentCompat() {

    lateinit var butt: Preference

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        val viewModel = getViewModel<SettingsViewModel>()
        setPreferencesFromResource(R.xml.settings, rootKey)

        val quitButton: Preference = findPreference("quit")!!
        val clearButton: Preference = findPreference("clear_statistics")!!

        butt = findPreference("notifications")!!

        quitButton.onPreferenceClickListener =
            Preference.OnPreferenceClickListener { //code for what you want it to do
                AppPreference.setInitUser(false)
                AppPreference.googleUserSignOut()
                findNavController().navigate(R.id.action_fragmentSettings_to_sigInFragment)
                true
            }

        clearButton.onPreferenceClickListener =
            Preference.OnPreferenceClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    viewModel.clearStatistics()
                }
                true
            }
    }
}