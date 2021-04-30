package com.example.finema.ui.tmp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finema.databinding.TmpFragmentBinding
import com.example.finema.ui.base.BaseFragment
import com.google.firebase.auth.FirebaseAuth

class TmpFragment: BaseFragment<TmpViewModel, TmpFragmentBinding>() {

    private lateinit var mAuth: FirebaseAuth
    private val viewModel: TmpViewModel = TmpViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TmpFragmentBinding.inflate(inflater, container, false)
        mAuth = FirebaseAuth.getInstance()
        viewModel.logIn(requireActivity())
        return binding.root
    }

}