package com.example.finema.ui.tmp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.finema.R
import com.example.finema.databinding.TmpFragmentBinding
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.AppPreference
import com.example.finema.util.downloadAndSetImageUri
import com.example.finema.util.downloadAndSetImageUrl
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
        if (AppPreference.getFirstSignIn() && AppPreference.getGuestOrAuth() == "AUTH"){
            viewModel.initRoomFromFirebaseToRoom()
            AppPreference.setFirstSignIn(false)
        }

        super.onViewCreated(view, savedInstanceState)
        binding.genre.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_tmp_to_fragment_genre)
            AppPreference.setTournamentType("GENRE")
        }

        binding.category.setOnClickListener{
            findNavController().navigate(R.id.action_fragment_tmp_to_fragment_others)
            AppPreference.setTournamentType("CATEGORY")
        }
    }



}
