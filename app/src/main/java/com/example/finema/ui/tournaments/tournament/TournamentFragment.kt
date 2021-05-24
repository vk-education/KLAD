package com.example.finema.ui.tournaments.tournament

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.finema.R
import com.example.finema.databinding.FragmentTournamentBinding
import com.example.finema.models.movieResponse.Movie
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.APP_ACTIVITY
import com.example.finema.util.downloadAndSetImage
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.properties.Delegates

class TournamentFragment : BaseFragment<TournamentVM, FragmentTournamentBinding>() {

    private var numFilms by Delegates.notNull<Int>()
    private lateinit var genreFilm: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTournamentBinding
            .inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()

        super.onViewCreated(view, savedInstanceState)
        // get number from previous fragment
        numFilms = arguments?.getSerializable("num") as Int
        genreFilm = arguments?.getSerializable("genre") as String

        viewModel.twoFilms.observe(APP_ACTIVITY,{

            binding.txtFilm1.text = it[0].title
            binding.txtFilm2.text = it[1].title

            binding.img1.downloadAndSetImage(
                getString(
                    R.string.poster_base_url,
                    it[0].posterPath)
            )
            binding.img2.downloadAndSetImage(
                getString(
                    R.string.poster_base_url,
                    it[1].posterPath)
            )

            binding.progressBar.visibility = View.GONE
            binding.cardview1.visibility = View.VISIBLE
            binding.cardview2.visibility = View.VISIBLE

            binding.txtNumCategory.text = "$numFilms Лучших фильмов"
            binding.roundCount.text = "Раунд ${viewModel.roundCount}"

            binding.cardview1.setOnClickListener {
                viewModel.itemClick(0)
            }

            binding.cardview2.setOnClickListener {
                viewModel.itemClick(1)
            }
        })
//        viewModel.filmListVM.observe(APP_ACTIVITY, {
////            allFilms = it as ArrayList<Movie>
////            mListFilms = allFilms.take(numFilms) as ArrayList<Movie>
//
////            binding.progressBar.visibility = View.GONE
////            binding.cardview1.visibility = View.VISIBLE
////            binding.cardview2.visibility = View.VISIBLE
//            // first initialization of cards (image and text)
//
////            fillCard(mListFilms)
//        })




//        viewModel.getMovies(genreFilm)

        binding.bookmark1.setOnClickListener{
            Toast.makeText(context,"Логики нет", Toast.LENGTH_SHORT).show()
            binding.bookmark1.setImageResource(R.drawable.bookmark_24)
        }

        binding.bookmark2.setOnClickListener{
            Toast.makeText(context,"Логики нет", Toast.LENGTH_SHORT).show()
            binding.bookmark2.setImageResource(R.drawable.bookmark_24)
        }
    }

    private fun fillTwo() {

    }

//    private fun clickSecondButton() {
//        if (flagMain) {
//            mListFilms2.add(el2)
//            mListFilms.remove(el1)
//            mListFilms.remove(el2)
//            if (mListFilms.isNotEmpty()) {
//                fillCard(mListFilms)
//            } else {
//                roundCount += 1
//                binding.roundCount.text =  getString(R.string.round, roundCount)
//                flagMain = false
//                fillCard(mListFilms2)
//            }
//        } else {
//            mListFilms.add(el2)
//            mListFilms2.remove(el1)
//            mListFilms2.remove(el2)
//            if (mListFilms2.isNotEmpty()) {
//                fillCard(mListFilms2)
//            } else {
//                roundCount += 1
//                binding.roundCount.text =  getString(R.string.round, roundCount)
//                flagMain = true
//                fillCard(mListFilms)
//            }
//        }
//    }
//
//    private fun clickFirstButton() {
//        if (flagMain) {
//            mListFilms2.add(el1)
//            mListFilms.remove(el1)
//            mListFilms.remove(el2)
//            if (mListFilms.isNotEmpty()) {
//                fillCard(mListFilms)
//            } else {
//                roundCount += 1
//                binding.roundCount.text =  getString(R.string.round, roundCount)
//                flagMain = false
//                fillCard(mListFilms2)
//            }
//        } else {
//            mListFilms.add(el1)
//            mListFilms2.remove(el1)
//            mListFilms2.remove(el2)
//            if (mListFilms2.isNotEmpty()) {
//                fillCard(mListFilms2)
//            } else {
//                roundCount += 1
//                binding.roundCount.text = getString(R.string.round, roundCount)
//                flagMain = true
//                fillCard(mListFilms)
//            }
//        }
//    }


//    private fun fillCard(list: MutableList<Movie>) {
//        el1 = list.random()
//        el2 = list.random()
//        if (list.size == 1 && el1 == el2) {
//            Toast.makeText(APP_ACTIVITY, "Победил " + el1.title, Toast.LENGTH_SHORT).show()
//            val bundle = Bundle()
//            val filmIdInfo = el1.id.toLong()
//            bundle.putSerializable("filmId", filmIdInfo)
//            Navigation.findNavController(APP_ACTIVITY, R.id.fragment)
//                .navigate(R.id.action_fragment_tournament_to_fragment_film, bundle)
//            roundCount = 1
//        } else {
//            while (el1 == el2) {
//                el2 = list.random()
//            }
//            binding.txtFilm1.text = el1.title
//            binding.txtFilm2.text = el2.title
//
//            binding.img1.downloadAndSetImage(
//                getString(
//                    R.string.poster_base_url,
//                    el1.posterPath)
//            )
//            binding.img2.downloadAndSetImage(
//                getString(
//                    R.string.poster_base_url,
//                    el2.posterPath)
//            )
//        }
//
//    }
//
//    companion object{
//        const val POSTER_BASE_URL =  "https://image.tmdb.org/t/p/w342"
//    }

}






