package com.example.finema.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {

    val publicErrorMessage: LiveData<String>
        get() = errorMessage

    private val errorMessage = MutableLiveData<String>()

    fun showError(throwable: Throwable) = errorMessage.postValue("ERROR")
}
