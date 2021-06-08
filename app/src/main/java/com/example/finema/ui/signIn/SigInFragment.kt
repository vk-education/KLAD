package com.example.finema.ui.signIn

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.finema.R
import com.example.finema.databinding.SignInFragmentBinding
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.AppPreference
import com.example.finema.util.downloadAndSetImageUri
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SigInFragment : BaseFragment<SignInViewModel, SignInFragmentBinding>() {

    private lateinit var header: TextView
    private lateinit var avatar: ImageView

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

        header = requireActivity().findViewById<NavigationView>(R.id.nav_view)
            .getHeaderView(0).findViewById(R.id.nickProfile)
        avatar = requireActivity().findViewById<NavigationView>(R.id.nav_view)
            .getHeaderView(0).findViewById(R.id.userAvatar)

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
            avatar.downloadAndSetImageUri(Uri.parse(DEFAULT_URI))
            findNavController().navigate(R.id.action_sigInFragment_to_tmpFragment)
        }
    }

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
        avatar.downloadAndSetImageUri(viewModel.mAuth.currentUser?.photoUrl)
        findNavController().navigate(R.id.action_sigInFragment_to_tmpFragment)
    }

    //TODO Исправить
    private fun blockBack() {
        binding.root.isFocusableInTouchMode = true
        binding.root.requestFocus()
        binding.root.setOnKeyListener(
            View.OnKeyListener { _, keyCode, event ->
                if (event.action === KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        return@OnKeyListener true
                    }
                }
                false
            }
        )
    }

    companion object {
        private const val DEFAULT_URI =
            "android.resource://com.example.finema/drawable/default_profile_avatar"
    }
}
