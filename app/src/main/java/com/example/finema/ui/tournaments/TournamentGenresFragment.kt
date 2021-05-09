package com.example.finema.ui.tournaments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.finema.R
import com.example.finema.api.DimaVersion.ApiInterface
import com.example.finema.api.DimaVersion.Common
import com.example.finema.databinding.FragmentTournamentGenresBinding
import com.example.finema.models.movieResponse.MovieResponse
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.ui.base.BaseFragment
import com.example.finema.utlis.APP_ACTIVITY
import retrofit2.Call
import retrofit2.Response

class TournamentGenresFragment :
    BaseFragment<TournamentGenresVM, FragmentTournamentGenresBinding>() {

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

    companion object {
        fun click(genre: GenreModel, num:Int) {
            Log.d("fufu", genre.id.toString())
            getFilmList(genre.id.toString(), num)
        }

        private fun getFilmList(genreID: String, num:Int) {
            val mService: ApiInterface = Common.retrofitService
            mService.getFilm(genreID).enqueue(object : retrofit2.Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    val responseBody = response.body()!!
                    val listFilmResponse = ArrayList(responseBody.movies)
                    Log.d("WTF", listFilmResponse.toString())
                    val bundle = Bundle()
                    bundle.putParcelableArrayList("list", listFilmResponse)
                    bundle.putSerializable("num", num)
                    Navigation.findNavController(APP_ACTIVITY, R.id.fragment)
                        .navigate(R.id.action_fragmentGenre_to_fragmentTournament,bundle)

                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.d("WTF1", "Fail" + t.message)
                }
            })
        }



    }



}
