package com.example.finema.ui.signIn

import com.example.finema.repositories.Contract
import com.example.finema.repositories.IAppPreference
import com.example.finema.ui.base.BaseViewModel
import com.google.firebase.auth.FirebaseAuth

class SignInViewModel(
    val contract: Contract,
    private val appPreference: IAppPreference
) : BaseViewModel() {

    val mAuth = FirebaseAuth.getInstance()

    init {
        contract.setName("")
    }

    fun signInAuth() {
        appPreference.setFirstSignIn(true)
        appPreference.setInitUser(true)
        appPreference.setGuestOrAuth("AUTH")
    }

    fun signInGuest() {
        appPreference.setInitUser(true)
        appPreference.setGuestOrAuth("GUEST")
    }
}
