package com.example.finema.ui.tournaments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.finema.R
import com.example.finema.api.RetrofitInterface
import com.example.finema.databinding.FragmentTournamentGenresBinding
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.models.sub_model.GenreList
import com.example.finema.ui.base.BaseFragment
import com.example.finema.utlis.APP_ACTIVITY
import retrofit2.Call
import retrofit2.Response

class TournamentGenresFragment : BaseFragment<TournamentGenresVM, FragmentTournamentGenresBinding>() {

    private lateinit var mViewModel: TournamentGenresVM
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: TournamentAdapter
    private lateinit var mObserverList: Observer<List<GenreModel>>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTournamentGenresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }

    private fun initialization() {
        mAdapter = TournamentAdapter()
        mRecyclerView = binding.tournamentsRecycler
        mRecyclerView.adapter = mAdapter
        mObserverList = Observer {
            val list = it
            mAdapter.setList(list)
        }
        mViewModel = ViewModelProvider(this).get(TournamentGenresVM::class.java)
        mViewModel.allGenres.observe(APP_ACTIVITY, mObserverList)
    }




}