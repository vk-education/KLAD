package com.example.finema.ui.tournaments

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.finema.R
import com.example.finema.databinding.FragmentTournamentDuoBinding
import com.example.finema.models.movieResponse.Movie
import com.example.finema.repositories.Singleton
import com.example.finema.ui.base.BaseFragment
import com.example.finema.ui.higherlower.MovieAdapter
import com.example.finema.util.downloadAndSetImage
import com.example.finema.utlis.APP_ACTIVITY


class TournamentDuo : BaseFragment<TournamentGenresVM, FragmentTournamentDuoBinding>() {
    private var mListFilms: ArrayList<Movie> = ArrayList()
    private var mListFilms2: ArrayList<Movie> = ArrayList()

    private lateinit var el1: Movie
    private lateinit var el2: Movie

    private var roundCount = 1
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
        // get List of Films and number from previous fragment
        val numFilms = arguments?.getSerializable("num") as Int
        // cut to num
        binding.txtNumCategory.text = "$numFilms Лучших фильмов"
        binding.roundCount.text = "Раунд $roundCount"
        mListFilms = Singleton.allFilms.take(numFilms) as ArrayList<Movie>
        Singleton.allFilms.clear()
        // first initialization of cards (image and text)
        fillCard(mListFilms)

        binding.cardview1.setOnClickListener {
            clickFirstButton()
        }

        binding.cardview2.setOnClickListener {
            clickSecondButton()
        }
    }

    private fun clickSecondButton() {
        if (flagMain) {
            mListFilms2.add(el2)
            mListFilms.remove(el1)
            mListFilms.remove(el2)
            if (mListFilms.isNotEmpty()) {
                fillCard(mListFilms)
            } else {
                roundCount += 1
                binding.roundCount.text = "Раунд " + roundCount
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
                roundCount += 1
                binding.roundCount.text = "Раунд " + roundCount
                flagMain = true
                fillCard(mListFilms)
            }
        }
    }

    private fun clickFirstButton() {
        if (flagMain) {
            mListFilms2.add(el1)
            mListFilms.remove(el1)
            mListFilms.remove(el2)
            if (mListFilms.isNotEmpty()) {
                fillCard(mListFilms)
            } else {
                roundCount += 1
                binding.roundCount.text = "Раунд " + roundCount
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
                roundCount += 1
                binding.roundCount.text = "Раунд " + roundCount
                flagMain = true
                fillCard(mListFilms)
            }
        }
    }


    private fun fillCard(list: MutableList<Movie>) {
        el1 = list.random()
        el2 = list.random()
        if (list.size == 1 && el1 == el2) {
            Toast.makeText(APP_ACTIVITY, "Победил " + el1.title, Toast.LENGTH_SHORT).show()
            val bundle = Bundle()
            val filmIdInfo = el1.id.toLong()
            bundle.putSerializable("filmId", filmIdInfo)
            Navigation.findNavController(APP_ACTIVITY, R.id.fragment)
                .navigate(R.id.action_fragment_tournament_to_fragment_film, bundle)
            roundCount = 1
        } else {
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






