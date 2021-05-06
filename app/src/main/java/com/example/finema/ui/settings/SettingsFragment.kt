package com.example.finema.ui.settings


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finema.databinding.SettingsFragmentBinding
import com.example.finema.databinding.TmpFragmentBinding
import com.example.finema.ui.base.BaseFragment
import com.google.firebase.auth.FirebaseAuth

class SettingsFragment: BaseFragment<SettingsViewModel, SettingsFragmentBinding>() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SettingsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}