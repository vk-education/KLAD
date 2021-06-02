package com.example.finema.ui.movieDetail

import android.os.Bundle
import android.util.Log
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
import com.example.finema.util.AppPreference
import com.example.finema.util.downloadAndSetImageUrl
import com.google.android.material.appbar.MaterialToolbar
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
        binding = MovieDetailsFragmentBinding
            .inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViewModel()
        super.onViewCreated(view, savedInstanceState)

        viewModel.film.observe(viewLifecycleOwner, observerList)

        viewModel.checkFavourite()

        binding.favourite.setOnClickListener {
            Log.d("gypsy", "Button is work")
            if (movie != null)
                addRemoveFavourite()
        }

    }

    private val observerList: Observer<MovieDetails> = Observer {
        binding.filmId = it

        binding.genres.text = viewModel.film.value!!.stringGenres

        binding.companies.text = viewModel.film.value!!.stringCompanies

        val image = requireActivity().findViewById<ImageView>(R.id.imageAppBar)

        val title = requireActivity().findViewById<MaterialToolbar>(R.id.topAppBar)

        title.title = it.title

        image.downloadAndSetImageUrl(
            POSTER_BASE_URL + it.posterPath
        )

        binding.rating.text = it.voteAverage.toString()

        if (viewModel.favouriteMovies != null && viewModel.favouriteMovies!!.contains(it.id.toLong())) {
            binding.favourite.setImageResource(R.drawable.bookmark_24)
            binding.favourite.tag = "yes"
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

        if (AppPreference.getFragment() == "Tournament fragment") {
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.addToTopMovies(
                    viewModel.toTopModel(movie!!)
                )
            }
        }

        afterLoading()
    }

    private fun initViewModel() {
        viewModel = getViewModel()
        viewModel.arg = requireArguments().getLong(KEY)
        viewModel.getMovieDetails()
    }

    private fun addRemoveFavourite() {
        if (binding.favourite.tag == "yes") {
            Toast.makeText(
                context,
                resources.getString(R.string.delete_from_favourite),
                Toast.LENGTH_SHORT
            ).show()
            animateBookmark(binding.favourite)
            binding.favourite.setImageResource(R.drawable.bookmark_border_24)
            viewModel.deleteMovie(movie!!.id, movie!!)
            binding.favourite.tag = "no"
        } else {
            Toast.makeText(
                context,
                resources.getString(R.string.add_to_favourite),
                Toast.LENGTH_SHORT
            ).show()
            animateBookmark(binding.favourite)
            binding.favourite.setImageResource(R.drawable.bookmark_24)
            viewModel.insert(movie!!)
            binding.favourite.tag = "yes"
        }

    }

    private fun animateBookmark(bookmark: ImageButton) {
        bookmark.animate().apply {
            duration = 250
            scaleXBy(1f)
            scaleYBy(1f)
        }.withEndAction {
            bookmark.animate().apply {
                duration = 250
                scaleXBy(-1f)
                scaleYBy(-1f)
            }
        }
    }

    fun afterLoading() {
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
    }

}