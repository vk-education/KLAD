package com.example.finema.ui.signIn

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.compose.registerForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.viewbinding.ViewBinding
import com.example.finema.R
import com.example.finema.databinding.FragmentBaseBinding
import com.example.finema.databinding.SignInFragmentBinding
import com.example.finema.databinding.TmpFragmentBinding
import com.example.finema.repo.Singleton
import com.example.finema.ui.base.BaseFragment
import com.example.finema.ui.base.BaseViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.sign_in_fragment.view.*


class SigInFragment: BaseFragment<SignInViewModel, SignInFragmentBinding>() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    private val viewModel = SignInViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignInFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

        googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)

        mAuth = FirebaseAuth.getInstance()

        binding.signInWithGoogle.setOnClickListener{
            viewModel.signIn(googleSignInClient)
            it.findNavController().navigate(R.id.action_sigInFragment_to_tmpFragment)
        }

        binding.signInAsGuest.setOnClickListener{
            Singleton.signInAsGuest = true
            it.findNavController().navigate(R.id.action_sigInFragment_to_tmpFragment)
        }
    }

}