package com.example.finema.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType
abstract class BaseFragment<VModel : BaseViewModel, Binding: ViewBinding>: Fragment() {

    private var viewModel: Lazy<VModel> = lazy {
        ViewModelProvider(requireActivity()).get(getViewModelClass())
    }
    
    protected lateinit var binding: Binding
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showError()
    }

    protected fun showError(){
        viewModel.value.publicErrorMessage.observe(viewLifecycleOwner){
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun getViewModelClass(): Class<VModel> {
        val type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        return type as Class<VModel>
    }
}

