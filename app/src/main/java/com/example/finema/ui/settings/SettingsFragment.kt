package com.example.finema.ui.settings

import android.os.Bundle
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.example.finema.R
import com.example.finema.util.AppPreference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.getViewModel


class SettingsFragment : PreferenceFragmentCompat() {
    private lateinit var viewModel: SettingsViewModel

    private lateinit var notification: Preference
    private lateinit var quit: Preference
    private lateinit var clear: Preference

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        viewModel = getViewModel()
        setPreferencesFromResource(R.xml.settings, rootKey)

        quit = findPreference("quit")!!
        clear = findPreference("clear_statistics")!!
        notification = findPreference("notifications")!!

        quit.onPreferenceClickListener =
            Preference.OnPreferenceClickListener { //code for what you want it to do
                AppPreference.setInitUser(false)
                AppPreference.googleUserSignOut()

                viewModel.deleteCache(requireContext())
                findNavController().navigate(R.id.action_fragmentSettings_to_sigInFragment)
                true
            }

        clear.onPreferenceClickListener =
            Preference.OnPreferenceClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    viewModel.clearStatistics()
                }

                Toast.makeText(context, R.string.clear, Toast.LENGTH_SHORT).show()
                true
            }
    }
}