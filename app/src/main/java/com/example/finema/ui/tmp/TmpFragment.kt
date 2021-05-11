package com.example.finema.ui.tmp

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.finema.R
import com.example.finema.databinding.TmpFragmentBinding
import com.example.finema.models.GenreRequest.GenreList
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.AppPreference
import com.google.firebase.auth.FirebaseAuth

class TmpFragment : BaseFragment<TmpViewModel, TmpFragmentBinding>() {

    private lateinit var mAuth: FirebaseAuth
    private val mViewModel = TmpViewModel(application = Application())
    private lateinit var mObserverList: Observer<GenreList>



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TmpFragmentBinding.inflate(inflater, container, false)
        mAuth = FirebaseAuth.getInstance()
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        if genre list not exist in database then download it
        if (!AppPreference.getGeneratedGenres()) {
            loadGenresList()
        }
        binding.genre.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragment_tmp_to_fragment_genre)
        }
    }

    private fun loadGenresList() {
        mObserverList = Observer {
            val list = it.genres
            for (item in list) {
                mViewModel.insert(GenreModel(name = item.name, id = item.id)) {
                    Log.d("testLog","Row inserted")
                }
            }
        }
        if (!AppPreference.getGeneratedGenres()) {
            mViewModel.getGenres()
        }
        mViewModel.getGenres()
        mViewModel.genreListVM.observe(viewLifecycleOwner, mObserverList)
        AppPreference.setGeneratedGenres(true)

    }


}
