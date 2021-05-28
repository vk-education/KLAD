package com.example.finema.ui.higherlowerrating

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import com.example.finema.R
import com.example.finema.databinding.HigherLowerRatingFragmentBinding
import com.example.finema.models.movieResponse.MovieResponse
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.AppPreference
import com.example.finema.util.downloadAndSetImageUrl
import org.koin.androidx.viewmodel.ext.android.getViewModel


class HigherLowerRatingFragment : BaseFragment<HigherLowerRatingViewModel, HigherLowerRatingFragmentBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HigherLowerRatingFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()
        super.onViewCreated(view, savedInstanceState)

        viewModel.movies.observe(viewLifecycleOwner, { movieList ->
            if(viewModel.score == 0) {
                viewModel.shuffle()
            }
            binding.txtFilm1.text = movieList.movies[viewModel.img1].title
            binding.txtFilm2.text = movieList.movies[viewModel.img2].title

            binding.txtRating.text = movieList.movies[viewModel.img1].voteAverage.toString()

            if(AppPreference.getMovieAddedToFav() == binding.txtFilm1.text) {
                binding.bookmark1.setImageResource(R.drawable.bookmark_24)
                binding.bookmark1.tag = "bruh"
            }

            setImage(0, movieList, binding.img1)
            setImage(1, movieList, binding.img2)
        })

        binding.bookmark1.setOnClickListener {
            setBookmarks(binding.bookmark1, 0)
        }

        binding.bookmark2.setOnClickListener {
            setBookmarks(binding.bookmark2, 1)
        }

    }

    private fun resetBookmarks() {
        binding.bookmark1.setImageResource(R.drawable.bookmark_border_24)
        binding.bookmark2.setImageResource(R.drawable.bookmark_border_24)
        binding.bookmark1.tag = ""
        binding.bookmark2.tag = ""
    }

    private fun setBookmarks(bookmark: ImageButton, position: Int) {
        if(bookmark.tag == "bruh") {
            Toast.makeText(context, "Удалено из избранные", Toast.LENGTH_SHORT).show()
            bookmark.setImageResource(R.drawable.bookmark_border_24)
            viewModel.removeFromFav(position)

            if(position == 1) {
                AppPreference.setMovieAddedToFav("")
            }

            bookmark.tag = "b"
        } else {
            Toast.makeText(context, "Добавлено в избранные", Toast.LENGTH_SHORT).show()
            bookmark.setImageResource(R.drawable.bookmark_24)
            viewModel.addToFav(position)

            if(position == 1) {
                AppPreference.setMovieAddedToFav(binding.txtFilm2.text as String)
            }

            bookmark.tag = "bruh"
        }

    }

    private fun setImage(imgIndex: Int, movieList: MovieResponse, img: ImageView) {
        img.downloadAndSetImageUrl(
            getString(
                R.string.poster_base_url,
                movieList.movies[imgIndex].posterPath)
        )

        img.setOnClickListener {
            resetBookmarks()
            viewModel.onMovieClicked(imgIndex)
            binding.points.text = getString(R.string.higher_lower_score, viewModel.score)
        }
    }

}
