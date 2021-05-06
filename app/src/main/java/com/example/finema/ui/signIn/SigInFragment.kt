package com.example.finema.ui.signIn

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import com.example.finema.R
import com.example.finema.databinding.SignInFragmentBinding
import com.example.finema.repositories.Singleton
import com.example.finema.ui.base.BaseFragment
import com.example.finema.utlis.APP_ACTIVITY
import com.example.finema.utlis.AppPreference
import com.example.finema.utlis.TYPE_ROOM
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider


class SigInFragment: BaseFragment<SignInViewModel, SignInFragmentBinding>() {
    private lateinit var header: TextView
    private lateinit var mAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    private val resultContract = registerForActivityResult(
        ActivityResultContracts
            .StartActivityForResult()){
        activityResult(it.data)
    }
    private val viewModel = SignInViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignInFragmentBinding.inflate(inflater, container, false)
        mViewModel = ViewModelProvider(this).get(SignInViewModel::class.java)
        // ≈—À» œŒÀ‹«Œ¬¿“≈À‹ ¿¬“Œ–»«Œ¬¿Õ, “Œ ‘–¿√Ã≈Õ“ ¿¬“Œ–»«¿÷»» — »œ¿≈“—ﬂ
        if (AppPreference.getInitUser()) {
            mViewModel.initDatabase(TYPE_ROOM) {
                Navigation.findNavController(APP_ACTIVITY, R.id.fragment)
                    .navigate(R.id.action_sigInFragment_to_tmpFragment)
            }
        }
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

        header = requireActivity().findViewById<NavigationView>(R.id.nav_view)
            .getHeaderView(0).findViewById(R.id.nickProfile)

        binding.signInWithGoogle.setOnClickListener{
            signIn()
            navigationOpen()
            it.findNavController().navigate(R.id.action_sigInFragment_to_tmpFragment)
        }

        binding.signInAsGuest.setOnClickListener{
            Singleton.signInAsGuest = true
            mViewModel.initDatabase(TYPE_ROOM) {
                AppPreference.setInitUser(true)
                header.text = resources.getText(R.string.guest)
                navigationOpen()
                it.findNavController().navigate(R.id.action_sigInFragment_to_tmpFragment)
            }

        }
    }

    private fun signIn(){
        val signInIntent = googleSignInClient.signInIntent
        resultContract.launch(signInIntent)
    }

    private fun activityResult(data: Intent?){
        val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
        val exception = task.exception
        if(task.isSuccessful) {
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account: GoogleSignInAccount? = task.getResult(ApiException::class.java)
                Log.d("Sign In Fragment", "firebaseAuthWithGoogle:" + account?.id)
                account?.idToken?.let { firebaseAuthWithGoogle(it) }

            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w("Sign In Fragment", "Google sign in failed", e)
            }
        }else{
            Log.w("Sign In Fragment", exception.toString())
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("firebaseAuthWithGoogle", "signInWithCredential:success")
                    val user = mAuth.currentUser
                    header.text = user?.displayName

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("firebaseAuthWithGoogle", "signInWithCredential:failure", task.exception)
                }
            }
    }

    private fun navigationOpen(){
        requireActivity().findViewById<DrawerLayout>(R.id.drawer_layout).setDrawerLockMode(DrawerLayout.LOCK_MODE_UNDEFINED)
        requireActivity().findViewById<MaterialToolbar>(R.id.topAppBar).visibility = View.VISIBLE
    }

    companion object{
        private const val RC_SIGN_IN = 120
    }

}