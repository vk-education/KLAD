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
import com.example.finema.util.AppPreference
import com.example.finema.util.downloadAndSetImageUrl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
        initViewModel()
        super.onViewCreated(view, savedInstanceState)

//        binding.filmLoader.visibility = View.GONE
        viewModel.film.observe(viewLifecycleOwner, observerList)

        viewModel.checkFavourite()

        binding.checkFavourite.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked && movie != null) {
                viewModel.insert(movie!!)
            } else if (!isChecked && movie != null) {
                CoroutineScope(Dispatchers.IO).launch {
                    viewModel.deleteMovie(movie!!.id)
                }
            }
        }

    }

    private val observerList: Observer<MovieDetails> = Observer {
        binding.layout.visibility = VISIBLE
//      binding.filmLoader.visibility = View.INVISIBLE

        binding.filmId = it

        binding.genres.text = viewModel.film.value!!.stringGenres

        binding.companies.text = viewModel.film.value!!.stringCompanies

        binding.imageView.downloadAndSetImageUrl(
            POSTER_BASE_URL + it.posterPath
        )

        binding.rating.text = it.voteAverage.toString()

//        if (viewModel.favouriteMovies == ){
//            Log.d("gypsy", "True")
//            binding.checkFavourite.isChecked = true
//        }

        Log.d("gypsy", "ObserverList")

        if (viewModel.favouriteMovies != null && viewModel.favouriteMovies!!.contains(it.id.toLong())) {
            Log.d("gypsy", "True")
            binding.checkFavourite.isChecked = true
        }

        movie = MovieModel(
            it.id.toLong(),
            it.title,
            POSTER_BASE_URL + it.posterPath,
            it.overview,
            null,
            it.voteAverage.toString(),
            null
        )
        if(AppPreference.getFragment() == "Tournament fragment") {
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.addToTopMovies(
                    viewModel.toTopModel(movie!!)
                )
            }
        }
    }

    private fun initViewModel() {
        viewModel = getViewModel()
        viewModel.arg = requireArguments().getLong(KEY)
        viewModel.getMovieDetails()
    }

    companion object {
        const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"
        const val KEY = "filmId"
    }

}