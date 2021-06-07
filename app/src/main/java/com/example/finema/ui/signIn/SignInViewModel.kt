package com.example.finema.ui.signIn

import com.example.finema.repositories.Contract
import com.example.finema.ui.base.BaseViewModel
import com.google.firebase.auth.FirebaseAuth
import org.koin.androidx.compose.get

class SignInViewModel(
    val contract: Contract
) : BaseViewModel() {

    val mAuth = FirebaseAuth.getInstance()

    init {
        contract.setName("")
    }
}
