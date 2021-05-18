package com.example.finema.ui.settings


import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.example.finema.R
import com.example.finema.util.AppPreference


class SettingsFragment: PreferenceFragmentCompat(){

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)


        val button: Preference = findPreference("quit")!!

        button.onPreferenceClickListener =
            Preference.OnPreferenceClickListener { //code for what you want it to do
                AppPreference.setInitUser(false)
                findNavController().navigate(R.id.action_fragmentSettings_to_sigInFragment)
                true
            }

    }

}