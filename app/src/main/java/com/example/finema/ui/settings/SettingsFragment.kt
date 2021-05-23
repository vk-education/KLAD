package com.example.finema.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.preference.Preference
import com.example.finema.R
import com.example.finema.databinding.SettingsFragmentBinding
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.AppPreference
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SettingsFragment
    : BaseFragment<SettingsViewModel, SettingsFragmentBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SettingsFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()
        super.onViewCreated(view, savedInstanceState)

        binding.exit.setOnClickListener {
            AppPreference.setInitUser(false)
            AppPreference.googleUserSignOut()
            findNavController().navigate(R.id.action_fragmentSettings_to_sigInFragment)
        }

        binding.notfications.setOnClickListener {
            
        }

    }
}