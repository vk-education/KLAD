package com.example.finema.ui.tournaments

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.finema.R
import com.example.finema.databinding.FragmentTournamentDuoBinding
import com.example.finema.models.movieResponse.Movie
import com.example.finema.ui.base.BaseFragment
import com.example.finema.ui.higherlower.MovieAdapter
import com.example.finema.util.downloadAndSetImage
import com.example.finema.utlis.APP_ACTIVITY


class TournamentDuo : BaseFragment<TournamentDuoVM, FragmentTournamentDuoBinding>() {
    private var mListFilms: MutableList<Movie> = mutableListOf<Movie>()
    private var mListFilms2: MutableList<Movie> = mutableListOf<Movie>()

    private lateinit var el1: Movie
    private lateinit var el2: Movie

    private var flagMain = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTournamentDuoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }


    private fun initialization() {
        mListFilms = arguments?.getParcelableArrayList<Movie>("list") as MutableList<Movie>
        val numFilms = arguments?.getSerializable("num") as Int
        mListFilms = mListFilms.take(numFilms) as MutableList<Movie>
        fillCard(mListFilms)
        el1 = mListFilms.random()
        el2 = mListFilms.random()
        while (el1 == el2) {
            el2 = mListFilms.random()
        }

        binding.txtFilm1.text = el1.title
        binding.txtFilm2.text = el2.title

        binding.img1.downloadAndSetImage(
            MovieAdapter.POSTER_BASE_URL +
                    el1.posterPath
        )
        binding.img2.downloadAndSetImage(
            MovieAdapter.POSTER_BASE_URL +
                    el2.posterPath
        )

        binding.cardview1.setOnClickListener {
            if (flagMain) {
                mListFilms2.add(el1)
                mListFilms.remove(el1)
                mListFilms.remove(el2)
                if (mListFilms.isNotEmpty()) {
                    fillCard(mListFilms)
                } else {
                    flagMain = false
                    fillCard(mListFilms2)
                }
            } else {
                mListFilms.add(el1)
                mListFilms2.remove(el1)
                mListFilms2.remove(el2)
                if (mListFilms2.isNotEmpty()) {
                    fillCard(mListFilms2)
                } else {
                    flagMain = true
                    fillCard(mListFilms)
                }
            }
            Log.d(
                "check123", "1:" + mListFilms.size.toString() +
                        " 2:" + mListFilms2.size.toString()
            )
        }

        binding.cardview2.setOnClickListener {
            if (flagMain) {
                mListFilms2.add(el2)
                mListFilms.remove(el1)
                mListFilms.remove(el2)
                if (mListFilms.isNotEmpty()) {
                    fillCard(mListFilms)
                } else {
                    flagMain = false
                    fillCard(mListFilms2)
                }
            } else {
                mListFilms.add(el2)
                mListFilms2.remove(el1)
                mListFilms2.remove(el2)
                if (mListFilms2.isNotEmpty()) {
                    fillCard(mListFilms2)
                } else {
                    flagMain = true
                    fillCard(mListFilms)
                }
            }
            Log.d(
                "check123", "1:" + mListFilms.size.toString() +
                        " 2:" + mListFilms2.size.toString()
            )
        }
    }


    private fun fillCard(list: MutableList<Movie>) {
        el1 = list.random()
        el2 = list.random()
        if (list.size == 1 && el1 == el2){
            Toast.makeText(APP_ACTIVITY, "Победил " + el1.title, Toast.LENGTH_SHORT).show()
            val bundle = Bundle()
            val filmIdInfo = el1.id.toLong()
            bundle.putSerializable("filmId", filmIdInfo)
            Navigation.findNavController(APP_ACTIVITY, R.id.fragment)
                .navigate(R.id.action_fragment_tournament_to_fragment_film,bundle)
        }
        else{
            while (el1 == el2) {
                el2 = list.random()
            }
            binding.txtFilm1.text = el1.title
            binding.txtFilm2.text = el2.title
            binding.img1.downloadAndSetImage(
                MovieAdapter.POSTER_BASE_URL +
                        el1.posterPath
            )
            binding.img2.downloadAndSetImage(
                MovieAdapter.POSTER_BASE_URL +
                        el2.posterPath
            )
        }

    }


}






