package com.example.finema.ui.settings


import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.finema.R

class SettingsFragment: PreferenceFragmentCompat(){

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)
    }

}