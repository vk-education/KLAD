package com.example.finema.ui.movieDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.finema.R
import com.example.finema.databinding.MovieDetailsFragmentBinding
import com.example.finema.models.databaseModels.MovieModel
import com.example.finema.models.movieResponse.MovieDetails
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.downloadAndSetImageUrl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MovieDetailsFragment : BaseFragment<MovieDetailsViewModel, MovieDetailsFragmentBinding>() {

    var movie: MovieModel = MovieModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MovieDetailsFragmentBinding
            .inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViewModel()
        super.onViewCreated(view, savedInstanceState)

        viewModel.film.observe(viewLifecycleOwner, observerList)
        viewModel.favouriteMovies.observe(viewLifecycleOwner, {})

        binding.favourite.setOnClickListener {
            addRemoveFavourite(movie.id)
        }
    }

    private val observerList: Observer<MovieDetails> = Observer {
        binding.filmId = it

        viewModel.film.value?.let { film ->
            binding.genres.text = film.stringGenres

            binding.companies.text = film.stringCompanies
        }

        val image = requireActivity().findViewById<ImageView>(R.id.imageAppBar)

        image.downloadAndSetImageUrl(
            POSTER_BASE_URL + it.posterPath
        )

        binding.rating.text = it.voteAverage.toString()

        if (viewModel.favouriteMovies.value!!.contains(it.id.toLong())) {
            binding.favourite.setImageResource(R.drawable.bookmark_24)
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

        if (viewModel.getFragment() == "Tournament fragment") {
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.addToTopMovies(
                    viewModel.toTopModel(movie)
                )
            }
        }

        afterLoading()
    }

    private fun initViewModel() {
        viewModel = getViewModel()
        viewModel.arg = requireArguments().getLong(KEY)
        viewModel.getMovieDetails()
        viewModel.checkFavourite()
    }

    private fun addRemoveFavourite(id: Long) {
        viewModel.favouriteMovies.value?.let {
            if (it.contains(id)) {
                deleteFilm()
            } else {
                addFilm()
            }
        }
    }

    private fun deleteFilm() {
        Toast.makeText(
            context,
            resources.getString(R.string.delete_from_favourite),
            Toast.LENGTH_SHORT
        ).show()
        animateBookmark(binding.favourite)
        binding.favourite.setImageResource(R.drawable.bookmark_border_24)
        viewModel.deleteMovie(movie.id, movie)
    }

    private fun addFilm() {
        Toast.makeText(
            context,
            resources.getString(R.string.add_to_favourite),
            Toast.LENGTH_SHORT
        ).show()
        animateBookmark(binding.favourite)
        binding.favourite.setImageResource(R.drawable.bookmark_24)
        viewModel.insert(movie)
    }

    private fun animateBookmark(bookmark: ImageButton) {
        bookmark.animate().apply {
            duration = ANIMATION_DURATION
            scaleXBy(ANIMATION_ROTATION)
            scaleYBy(ANIMATION_ROTATION)
        }.withEndAction {
            bookmark.animate().apply {
                duration = ANIMATION_DURATION
                scaleXBy(-ANIMATION_ROTATION)
                scaleYBy(-ANIMATION_ROTATION)
            }
        }
    }

    private fun afterLoading() {
        binding.filmLoader.visibility = View.INVISIBLE
        binding.aboutTitle.visibility = VISIBLE
        binding.genreTitle.visibility = VISIBLE
        binding.ratingTitle.visibility = VISIBLE
        binding.companiesTitle.visibility = VISIBLE
        binding.favourite.visibility = VISIBLE
    }

    companion object {
        const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"
        const val KEY = "filmId"
        private const val ANIMATION_DURATION = 250L
        private const val ANIMATION_ROTATION = 1f
    }
}
