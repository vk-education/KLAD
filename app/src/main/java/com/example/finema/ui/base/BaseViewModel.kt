package com.example.finema.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

open class BaseViewModel : ViewModel() {

    protected lateinit var job: Job

    val publicErrorMessage: LiveData<String>
        get() = errorMessage

    private val errorMessage = MutableLiveData<String>()

    fun showError(throwable: Throwable) = errorMessage.postValue("ERROR")
}
