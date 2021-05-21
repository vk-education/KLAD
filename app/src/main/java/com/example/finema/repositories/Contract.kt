package com.example.finema.repositories

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.result.contract.ActivityResultContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.finema.models.movieResponse.MovieResponse
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class Contract : ActivityResultContract<Unit, FirebaseAuth?>() {

    private val mAuth  = FirebaseAuth.getInstance()

    private var _movies = MutableLiveData<FirebaseAuth>()
    val movies: LiveData<FirebaseAuth>
        get() = _movies


    private val gso: GoogleSignInOptions = GoogleSignInOptions
        .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(defaultWebClientId)
        .requestEmail()
        .build()

    override fun createIntent(context: Context, input: Unit): Intent {
        val googleSignInClient = GoogleSignIn.getClient(context, gso)

        return  googleSignInClient.signInIntent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): FirebaseAuth? =
        activityResult(intent)

    private fun activityResult(data: Intent?): FirebaseAuth? {
        val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
        val exception = task.exception
        if(task.isSuccessful) {
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account: GoogleSignInAccount? = task.getResult(ApiException::class.java)
                Log.d("Sign In Fragment", "firebaseAuthWithGoogle:" + account?.id)
                return firebaseAuthWithGoogle(account?.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w("Sign In Fragment", "Google sign in failed", e)
                return null
            }
        }else{
            Log.w("Sign In Fragment", exception.toString())
            return null
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String): FirebaseAuth {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("firebaseAuthWithGoogle", "signInWithCredential:success")
                    val user = mAuth.currentUser
                    Log.d("WOW", user.displayName!!)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("firebaseAuthWithGoogle", "signInWithCredential:failure", task.exception)
                }
            }
        _movies.value = mAuth
        return mAuth
    }

    companion object {
        const val defaultWebClientId =
            "677958878281-pmcs285i4cdvd5tob7c6ovd2j0msknvs.apps.googleusercontent.com"
    }
}
