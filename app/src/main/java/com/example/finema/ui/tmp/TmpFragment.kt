package com.example.finema.ui.tmp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.finema.R
import com.example.finema.databinding.TmpFragmentBinding
import com.example.finema.models.GenreRequest.GenreList
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.AppPreference
import com.example.finema.util.TYPE_ROOM
import com.google.android.material.appbar.MaterialToolbar
import org.koin.androidx.viewmodel.ext.android.getViewModel

class TmpFragment : BaseFragment<TmpViewModel, TmpFragmentBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TmpFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()
        super.onViewCreated(view, savedInstanceState)
        requireActivity()
            .findViewById<DrawerLayout>(R.id.drawer_layout)
            .setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        //TODO убрать
        requireActivity().findViewById<MaterialToolbar>(R.id.topAppBar).visibility = View.VISIBLE
        binding.genre.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_tmp_to_fragment_genre)
        }
    }




}
