package com.example.finema.ui.higherlower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import com.example.finema.R
import com.example.finema.databinding.HigherLowerFragmentBinding
import com.example.finema.models.movieResponse.MovieResponse
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.downloadAndSetImageUrl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.getViewModel

class HigherLowerFragment : BaseFragment<HigherLowerViewModel, HigherLowerFragmentBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HigherLowerFragmentBinding.inflate(inflater, container, false)

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

                setImage(binding.img1, movieList, viewModel.img1)
                setImage(binding.img2, movieList, viewModel.img2)

                setBookmarkClickListeners(binding.bookmark1, 0)
                setBookmarkClickListeners(binding.bookmark2, 1)

                fillInBookmarks()
            }
        )
    }

    private fun setImage(image: ImageView, movieList: MovieResponse, imgInd: Int) {
        image.downloadAndSetImageUrl(
            getString(
                R.string.poster_base_url,
                movieList.movies[imgInd].posterPath
            )
        )
        image.setOnClickListener {
            resetBookmarks()
            viewModel.onMovieClicked(imgInd)
            binding.points.text = getString(
                R.string.higher_lower_score,
                viewModel.score
            )
        }
    }

    private fun setBookmarkClickListeners(bookmark: ImageButton, position: Int) {
        bookmark.setOnClickListener {
            setBookmarks(bookmark, position)
        }
    }

    private fun fillInBookmarks() {
        //TODO Удалить
        CoroutineScope(Dispatchers.Main).launch {
            viewModel.favouriteMovies.observe(
                viewLifecycleOwner,
                {
                    for (i in it) {
                        if (binding.txtFilm1.text == i.title) {
                            binding.bookmark1.setImageResource(
                                R.drawable.bookmark_24
                            )
                            binding.bookmark1.tag = "bruh"
                        }
                        if (binding.txtFilm2.text == i.title) {
                            binding.bookmark2.setImageResource(
                                R.drawable.bookmark_24
                            )
                            binding.bookmark2.tag = "bruh"
                        }
                    }
                }
            )
        }
    }

    private fun resetBookmarks() {
        binding.bookmark1.setImageResource(R.drawable.bookmark_border_24)
        binding.bookmark2.setImageResource(R.drawable.bookmark_border_24)
        binding.bookmark1.tag = ""
        binding.bookmark2.tag = ""
    }

    private fun setBookmarks(bookmark: ImageButton, position: Int) {
        if (bookmark.tag == "bruh") {
            animateBookmark(bookmark)

            Toast.makeText(
                context,
                resources.getString(R.string.delete_from_favourite),
                Toast.LENGTH_SHORT
            ).show()
            bookmark.setImageResource(R.drawable.bookmark_border_24)
            viewModel.removeFromFav(position)

            bookmark.tag = "b"
        } else {
            animateBookmark(bookmark)

            Toast.makeText(
                context,
                resources.getString(R.string.add_to_favourite),
                Toast.LENGTH_SHORT
            ).show()
            bookmark.setImageResource(R.drawable.bookmark_24)
            viewModel.addToFav(position)

            bookmark.tag = "bruh"
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
