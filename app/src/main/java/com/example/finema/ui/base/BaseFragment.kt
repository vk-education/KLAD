package com.example.finema.ui.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<VModel : BaseViewModel, Binding : ViewBinding> : Fragment() {

    protected open lateinit var viewModel: VModel

    protected lateinit var binding: Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showError()
    }

    protected fun showError() {
        viewModel.publicErrorMessage.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun getViewModelClass(): Class<VModel> {
        val type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        return type as Class<VModel>
    }
}
