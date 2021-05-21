package com.example.finema.ui.tournaments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.finema.R
import com.example.finema.databinding.FragmentTournamentDuoBinding
import com.example.finema.models.movieResponse.Movie
import com.example.finema.ui.base.BaseFragment
import com.example.finema.ui.tournaments.genres.GenresTournamentVM
import com.example.finema.util.downloadAndSetImage
import com.example.finema.util.APP_ACTIVITY
import org.koin.androidx.viewmodel.ext.android.getViewModel

//TODO Вынести всю логику во VM
class TournamentFragment : BaseFragment<GenresTournamentVM, FragmentTournamentDuoBinding>() {

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
        binding = FragmentTournamentDuoBinding
            .inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()

        super.onViewCreated(view, savedInstanceState)
        // get List of Films and number from previous fragment
        val allFilms = arguments?.getParcelableArrayList<Movie>("list") as ArrayList<Movie>
        val numFilms = arguments?.getSerializable("num") as Int
        // cut to num
        // cum to nut hehehe
        //TODO Убрать строки в ресурсы
        binding.txtNumCategory.text = getString(R.string.n_best_movies, numFilms)
        binding.roundCount.text = getString(R.string.round, roundCount)
        mListFilms = allFilms.take(numFilms) as ArrayList<Movie>
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
                binding.roundCount.text =  getString(R.string.round, roundCount)
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
                binding.roundCount.text =  getString(R.string.round, roundCount)
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
                binding.roundCount.text =  getString(R.string.round, roundCount)
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
                binding.roundCount.text = getString(R.string.round, roundCount)
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
                getString(
                    R.string.poster_base_url,
                    el1.posterPath)
            )
            binding.img2.downloadAndSetImage(
                getString(
                    R.string.poster_base_url,
                    el2.posterPath)
            )
        }

    }

}






