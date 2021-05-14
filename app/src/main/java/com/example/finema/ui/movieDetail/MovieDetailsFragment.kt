package com.example.finema.ui.movieDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.finema.databinding.MovieDetailsFragmentBinding
import com.example.finema.ui.base.BaseFragment
import com.example.finema.ui.higherlower.CustomGridLayoutManager

class MovieDetailsFragment: BaseFragment<MovieDetailsViewModel, MovieDetailsFragmentBinding>() {

    //TODO убрать после фикса viewModel
    private lateinit var factory: MovieDetailsViewModelFactory
    //TODO убрать
    private lateinit var layout : CustomGridLayoutManager
    //TODO Аналогично строке 16
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

    //TODO убрать подготовку данных в VM
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

            //TODO изменить на вызов extension
            Glide.with(view)
                .load(it.posterPath)
                .into(binding.imageView)

            binding.rating.text = it.voteAverage.toString()
        })
    }

}