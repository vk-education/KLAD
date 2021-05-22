package com.example.finema.ui.movieDetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.finema.databinding.MovieDetailsFragmentBinding
import com.example.finema.models.GenreRequest.GenreList
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.models.movieResponse.MovieDetails
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.downloadAndSetImage
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MovieDetailsFragment : BaseFragment<MovieDetailsViewModel, MovieDetailsFragmentBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MovieDetailsFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    //TODO убрать подготовку данных в VM
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()

        viewModel.arg = requireArguments().getLong(KEY)

//        binding.filmLoader.visibility = View.GONE
        viewModel.film.observe(viewLifecycleOwner, observerList)

    }

    private val observerList: Observer<MovieDetails> = Observer {
        binding.layout.visibility = VISIBLE
//      binding.filmLoader.visibility = View.INVISIBLE

        binding.filmId = it

        for (item in it.genres) {
            viewModel.genres += item.name + NEW_LINE
        }
        binding.genres.text = viewModel.genres

        for (item in it.productionCompanies) {
            viewModel.companies += item.name + TAB + item.originCountry + NEW_LINE
        }
        binding.companies.text = viewModel.companies

        binding.imageView.downloadAndSetImage(
            POSTER_BASE_URL + it.posterPath
        )

        binding.rating.text = it.voteAverage.toString()

    }

    companion object {
        const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"
        const val STARTING_GENRE_VALUE = ""
        const val STARTING_COMPANIES_VALUE = ""
        const val NEW_LINE = "\n"
        const val TAB = "\t"
        const val KEY = "filmId"
    }

}