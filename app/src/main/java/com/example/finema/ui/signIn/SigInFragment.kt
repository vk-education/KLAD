package com.example.finema.ui.signIn

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.navigation.fragment.findNavController
import com.example.finema.R
import com.example.finema.databinding.SignInFragmentBinding
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.AppPreference
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.*
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlinx.coroutines.flow.collect


class SigInFragment : BaseFragment<SignInViewModel, SignInFragmentBinding>() {

    //TODO убрать, есть биндинг
    private lateinit var header: TextView

    @InternalCoroutinesApi
    private lateinit var customContract: ActivityResultLauncher<Unit>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignInFragmentBinding.inflate(inflater, container, false)
        // ���� ������������ �����������, �� �������� ����������� ���������
        return binding.root
    }

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()

        initCustomContract()

        super.onViewCreated(view, savedInstanceState)

        //TODO вынести во Repository, но только после того как будет DI (dagger/koin)

        header = requireActivity().findViewById<NavigationView>(R.id.nav_view)
            .getHeaderView(0).findViewById(R.id.nickProfile)

        viewModel.name.observe(viewLifecycleOwner, { name ->
            if (name != "") {
                header.text = name
                findNavController().navigate(R.id.action_sigInFragment_to_tmpFragment)
            } else {
                //начать анимацию загрузки
                //кстати реализцая хуйня
                //потом разберусь
                //или нет
                binding.signInWithGoogle.callOnClick()
            }
        })

        binding.signInWithGoogle.setOnClickListener {
            signIn()
            AppPreference.setInitUser(true)
        }

        binding.signInAsGuest.setOnClickListener {
            AppPreference.setInitUser(true)
            header.text = resources.getText(R.string.guest)
            findNavController().navigate(R.id.action_sigInFragment_to_tmpFragment)
        }
    }

    //TODO репозиторий по нажатию на кнопку возвращает интент, через VM, который и надо здесь
    // запускать
    @InternalCoroutinesApi
    private fun signIn() {
        customContract.launch(Unit)
    }

    @InternalCoroutinesApi
    private fun initCustomContract() {
        customContract = registerForActivityResult(viewModel.contract) {
            CoroutineScope(Dispatchers.Main).launch {
                it?.collect { value ->
                    Log.d("WeWantName", value?.currentUser?.displayName.orEmpty()
                            + "\t\tNothing")
                    viewModel.setName(value?.currentUser?.displayName.orEmpty())
                }
            }
        }
    }

}