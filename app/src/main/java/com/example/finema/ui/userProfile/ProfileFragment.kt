package com.example.finema.ui.userProfile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finema.databinding.ProfileFragmentBinding
import com.example.finema.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ProfileFragment: BaseFragment<ProfileViewModel, ProfileFragmentBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProfileFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()
        super.onViewCreated(view, savedInstanceState)


    }
}