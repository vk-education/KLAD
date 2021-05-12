package com.example.finema.ui.tournaments

import android.app.Application
import android.app.Dialog
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.finema.R
import com.example.finema.databinding.FragmentTournamentGenresBinding
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.models.movieResponse.Movie
import com.example.finema.ui.base.BaseFragment
import com.example.finema.utlis.APP_ACTIVITY

class TournamentGenresFragment :
    BaseFragment<TournamentGenresVM, FragmentTournamentGenresBinding>(),
    TournamentAdapter.TournamentHolder.Listener {

    private val mViewModel = TournamentGenresVM(Application())
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: TournamentAdapter
    private lateinit var mObserverList: Observer<List<GenreModel>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTournamentGenresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }

    private fun initialization() {
        mAdapter = TournamentAdapter(this)
        mRecyclerView = binding.tournamentsRecycler
        mRecyclerView.adapter = mAdapter
        mObserverList = Observer {
            mAdapter.setList(it)
        }
        mViewModel.allGenres.observe(viewLifecycleOwner, mObserverList)

        mViewModel.filmListVM.observe(viewLifecycleOwner, {
            dialogBinding(it)
        })
    }

    override fun onMovieClicked(view: View, genreModel: GenreModel) {
        getFilms(genreModel.id.toString())
    }


    private fun getFilms(genreID: String) {
        mViewModel.getMovies(genreID)
    }

    private fun dialogBinding(list1: List<Movie>) {
        val dialog = Dialog(APP_ACTIVITY)
        dialog.setContentView(R.layout.number_fragment)
        val btn8: TextView = dialog.findViewById(R.id.btn8)
        val btn16: Button = dialog.findViewById(R.id.btn16)
        val btn32: Button = dialog.findViewById(R.id.btn32)
        val btn64: Button = dialog.findViewById(R.id.btn64)
        val btn128: Button = dialog.findViewById(R.id.btn128)
        btn8.setOnClickListener {
            goNext(8, list1)
            dialog.hide()
        }
        btn16.setOnClickListener {
            goNext(16, list1)
            dialog.hide()
        }
//        btn32.setOnClickListener {
//            goNext(32)
//            dialog.hide()
//        }
//        btn64.setOnClickListener {
//            goNext(64)
//            dialog.hide()
//        }
//        btn128.setOnClickListener {
//            goNext( 128)
//            dialog.hide()
//        }
        dialog.show()
    }

    private fun goNext(num: Int, list1: List<Movie>) {
        val bundle = Bundle()
        bundle.putParcelableArrayList("list", list1 as java.util.ArrayList<out Parcelable>)
        bundle.putSerializable("num", num)
        Navigation.findNavController(APP_ACTIVITY, R.id.fragment)
            .navigate(R.id.action_fragmentGenre_to_fragmentTournament, bundle)
    }
}
