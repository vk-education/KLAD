package com.example.finema.ui.signIn

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.finema.R
import com.example.finema.databinding.SignInFragmentBinding
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.AppPreference
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.getViewModel


class SigInFragment : BaseFragment<SignInViewModel, SignInFragmentBinding>() {

    //TODO убрать, есть биндинг
    private lateinit var header: TextView

    @InternalCoroutinesApi
    private lateinit var customContract: ActivityResultLauncher<Unit>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignInFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()
        blockBack()
        initCustomContract()

        super.onViewCreated(view, savedInstanceState)
        //TODO вынести во Repository, но только после того как будет DI (dagger/koin)

        header = requireActivity().findViewById<NavigationView>(R.id.nav_view)
            .getHeaderView(0).findViewById(R.id.nickProfile)

        binding.signInWithGoogle.setOnClickListener {
            binding.loader.visibility = View.VISIBLE
            signIn()
            AppPreference.setFirstSignIn(true)
            AppPreference.setInitUser(true)
            AppPreference.setGuestOrAuth("AUTH")
        }

        binding.signInAsGuest.setOnClickListener {
            AppPreference.setInitUser(true)
            AppPreference.setGuestOrAuth("GUEST")
            header.text = resources.getText(R.string.guest)
            findNavController().navigate(R.id.action_sigInFragment_to_tmpFragment)
        }
    }

    //TODO репозиторий по нажатию на кнопку возвращает интент, через VM, который и надо здесь
    // запускать
    @InternalCoroutinesApi
    private fun signIn() {
        customContract.launch(Unit)
    }

    @InternalCoroutinesApi
    private fun initCustomContract() {
        customContract = registerForActivityResult(viewModel.contract) {
            lifecycleScope.launchWhenStarted {
                viewModel.contract.name.collect { name ->
                    when (name) {
                        "" -> Unit
                        else -> letUserIn(name)
                    }
                }
            }
        }
    }

    private fun letUserIn(name: String) {
        Log.d("ID", viewModel.mAuth.currentUser?.uid.toString())
        binding.loader.visibility = View.INVISIBLE
        header.text = name
        findNavController().navigate(R.id.action_sigInFragment_to_tmpFragment)

    }

    private fun blockBack() {
        binding.root.isFocusableInTouchMode = true;
        binding.root.requestFocus();
        binding.root.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (event.action === KeyEvent.ACTION_DOWN) {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    return@OnKeyListener true
                }
            }
            false
        })

    }

}