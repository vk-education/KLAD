package com.example.finema.ui.higherlowerrating

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.finema.R
import com.example.finema.databinding.HigherLowerRatingFragmentBinding
import com.example.finema.models.movieResponse.MovieResponse
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.downloadAndSetImageUrl
import org.koin.androidx.viewmodel.ext.android.getViewModel

class HigherLowerRatingFragment :
    BaseFragment<HigherLowerRatingViewModel, HigherLowerRatingFragmentBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HigherLowerRatingFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()
        super.onViewCreated(view, savedInstanceState)

        viewModel.movies.observe(
            viewLifecycleOwner,
            { movieList ->
                if (viewModel.score == 0) {
                    viewModel.shuffle()
                }
                binding.txtFilm1.text = movieList.movies[viewModel.img1].title
                binding.txtFilm2.text = movieList.movies[viewModel.img2].title
                binding.points.text = getString(R.string.n_points, viewModel.score)
                binding.txtRating.text = movieList.movies[viewModel.img1].voteAverage.toString()

                setImage(binding.img1, movieList, viewModel.img1)
                setImage(binding.img2, movieList, viewModel.img2)

                fillInBookmarks(binding.txtFilm1, binding.bookmark1)
                fillInBookmarks(binding.txtFilm2, binding.bookmark2)
            }
        )

        setBookmarkClickListeners(binding.bookmark1, binding.txtFilm1, 0)
        setBookmarkClickListeners(binding.bookmark2, binding.txtFilm2, 1)
    }

    private fun setImage(image: ImageView, movieList: MovieResponse, imgInd: Int) {
        image.downloadAndSetImageUrl(
            getString(
                R.string.poster_base_url,
                movieList.movies[imgInd].posterPath
            )
        )
        image.setOnClickListener {
            viewModel.onMovieClicked(imgInd)
            binding.points.text = getString(
                R.string.higher_lower_score,
                viewModel.score
            )
        }
    }

    private fun setBookmarkClickListeners(bookmark: ImageButton, title: TextView, position: Int) {
        bookmark.setOnClickListener {
            animateBookmark(bookmark)
            addODelFav(title, position)
        }
    }

    private fun fillInBookmarks(txtview: TextView, bookmark: ImageButton) {
        viewModel.favouriteMovies.observe(
            viewLifecycleOwner,
            {
                var counter = 0
                for (i in it) {
                    counter += 1
                    if (txtview.text == i.title) {
                        bookmark.setImageResource(
                            R.drawable.bookmark_24
                        )
                        break
                    }
                    if (counter == it.size) {
                        bookmark.setImageResource(
                            R.drawable.bookmark_border_24
                        )
                    }
                }
            }
        )
    }

    private fun addODelFav(title: TextView, position: Int) {
        viewModel.favouriteMovies.value?.let {
            var counter = 0
            for (i in it) {
                counter += 1
                if (title.text == i.title || title.text == i.originalTitle) {
                    viewModel.removeFromFav(position)
                    break
                }
                if (it.size == counter) {
                    viewModel.addToFav(position)
                }
            }
        }
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

    companion object {
        private const val ANIMATION_DURATION = 250L
        private const val ANIMATION_ROTATION = 1f
    }
}
