package com.example.finema.ui.signIn

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.util.Log
import androidx.activity.result.contract.ActivityResultContract
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finema.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class Contract : ActivityResultContract<Context, Unit>() {

    private val mAuth  = FirebaseAuth.getInstance()

    private val gso: GoogleSignInOptions = GoogleSignInOptions
        .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken("677958878281-pmcs285i4cdvd5tob7c6ovd2j0msknvs.apps.googleusercontent.com")
        .requestEmail()
        .build()

    override fun createIntent(context: Context, input: Context): Intent {
        val googleSignInClient = GoogleSignIn.getClient(input, gso)

        return  googleSignInClient.signInIntent
    }

    override fun parseResult(resultCode: Int, intent: Intent?) =
        activityResult(intent)


    private fun activityResult(data: Intent?){
        val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
        val exception = task.exception
        if(task.isSuccessful) {
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account: GoogleSignInAccount? = task.getResult(ApiException::class.java)
                Log.d("Sign In Fragment", "firebaseAuthWithGoogle:" + account?.id)
                firebaseAuthWithGoogle(account?.idToken!!)

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
    }


}
