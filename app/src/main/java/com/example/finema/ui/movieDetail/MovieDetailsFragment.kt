package com.example.finema.ui.movieDetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.finema.databinding.MovieDetailsFragmentBinding
import com.example.finema.models.databaseModels.MovieModel
import com.example.finema.models.movieResponse.MovieDetails
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.downloadAndSetImage
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MovieDetailsFragment : BaseFragment<MovieDetailsViewModel, MovieDetailsFragmentBinding>() {

    var movie: MovieModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MovieDetailsFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()
        super.onViewCreated(view, savedInstanceState)

        viewModel.arg = requireArguments().getLong(KEY)

        viewModel = getViewModel()

//        binding.filmLoader.visibility = View.GONE
        viewModel.film.observe(viewLifecycleOwner, observerList)
        
        binding.checkFavourite.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked && movie != null){
                viewModel.insert(movie!!)
            }
        }

    }

    private val observerList: Observer<MovieDetails> = Observer {
        binding.layout.visibility = VISIBLE
//      binding.filmLoader.visibility = View.INVISIBLE

        binding.filmId = it

        binding.genres.text = viewModel.film.value!!.stringGenres

        binding.companies.text = viewModel.film.value!!.stringCompanies

        binding.imageView.downloadAndSetImage(
            POSTER_BASE_URL + it.posterPath
        )

        binding.rating.text = it.voteAverage.toString()

        if (viewModel.checkFavourite(it.id.toLong())){
            Log.d("gypsy", "True")
            binding.checkFavourite.isChecked = true
        }

        movie = MovieModel(
            it.id.toLong(),
            it.title,
            null,
            it.overview,
            null,
            it.voteAverage.toString(),
            null
        )
    }



    companion object {
        const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"
        const val KEY = "filmId"
    }

}