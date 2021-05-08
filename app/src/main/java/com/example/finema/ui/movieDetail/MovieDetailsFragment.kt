package com.example.finema.ui.movieDetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.finema.R
import com.example.finema.api.MoviesApi
import com.example.finema.databinding.MovieDetailsFragmentBinding
import com.example.finema.newapi.MoviesRepository
import com.example.finema.ui.base.BaseFragment
import com.example.finema.ui.higherlower.CustomGridLayoutManager
import com.example.finema.ui.higherlower.HigherLowerViewModel
import kotlin.math.log

class MovieDetailsFragment: BaseFragment<MovieDetailsViewModel, MovieDetailsFragmentBinding>() {

    private lateinit var factory: MovieDetailsViewModelFactory
    private lateinit var layout : CustomGridLayoutManager
    private val viewModel = MovieDetailsViewModel()
    private var arg: Long = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val smt = requireArguments().getLong("filmId")

        binding = MovieDetailsFragmentBinding.inflate(inflater, container, false)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        layout = CustomGridLayoutManager(requireContext())
        factory = MovieDetailsViewModelFactory()
        arg = requireArguments().getLong("filmId")
        viewModel.getMovieDetails(arg)

//        binding.filmLoader.visibility = GONE

        viewModel.film.observe(viewLifecycleOwner, {
            binding.layout.visibility = VISIBLE
//            binding.filmLoader.visibility = INVISIBLE

            it.posterPath = "https://image.tmdb.org/t/p/w342" + it.posterPath
            binding.filmId = it

            var genres = ""
            for (item in it.genres){
                genres += item.name + "\n"
            }
            binding.genres.text = genres

            var companies = ""
            for (item in it.productionCompanies){
                companies += item.name + "\t" + item.originCountry + "\n"
            }
            binding.companies.text = companies

            Glide.with(view)
                .load(it.posterPath)
                .into(binding.imageView)

            binding.rating.text = it.voteAverage.toString()
        })
    }

}