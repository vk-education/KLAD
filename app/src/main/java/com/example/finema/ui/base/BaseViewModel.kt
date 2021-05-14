package com.example.finema.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job


//TODO Разобраться с application
open class BaseViewModel(
): ViewModel() {

    protected lateinit var job: Job

    val publicErrorMessage: LiveData<String>
        get() = errorMessage

    private val errorMessage = MutableLiveData<String>()

    fun showError(throwable: Throwable) = errorMessage.postValue("ERROR")


}
