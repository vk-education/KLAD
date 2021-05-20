package com.example.finema.ui.movieDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.finema.databinding.MovieDetailsFragmentBinding
import com.example.finema.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MovieDetailsFragment : BaseFragment<MovieDetailsViewModel, MovieDetailsFragmentBinding>() {
    private var arg: Long = 0

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
        arg = requireArguments().getLong(KEY)
        viewModel = getViewModel()

        viewModel.getMovieDetails(arg)

//        binding.filmLoader.visibility = View.GONE

        viewModel.film.observe(viewLifecycleOwner, {
            binding.layout.visibility = VISIBLE
//            binding.filmLoader.visibility = View.INVISIBLE

            it.posterPath = POSTER_BASE_URL + it.posterPath
            binding.filmId = it

            var genres = STARTING_GENRE_VALUE
            for (item in it.genres) {
                genres += item.name + NEW_LINE
            }
            binding.genres.text = genres

            var companies = STARTING_COMPANIES_VALUE
            for (item in it.productionCompanies) {
                companies += item.name + TAB + item.originCountry + NEW_LINE
            }
            binding.companies.text = companies

            //TODO изменить на вызов extension
            Glide.with(view)
                .load(it.posterPath)
                .into(binding.imageView)

            binding.rating.text = it.voteAverage.toString()
        })
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