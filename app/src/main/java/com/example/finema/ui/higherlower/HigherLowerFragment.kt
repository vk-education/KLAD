package com.example.finema.ui.higherlower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.finema.R
import com.example.finema.databinding.HigherLowerFragmentBinding
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.POSTER_BASE_URL
import com.example.finema.util.downloadAndSetImage
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.getViewModel


class HigherLowerFragment : BaseFragment<HigherLowerViewModel, HigherLowerFragmentBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HigherLowerFragmentBinding.inflate(inflater, container, false)

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

            binding.img1.downloadAndSetImage(
                getString(
                    R.string.poster_base_url,
                    movieList.movies[viewModel.img1].posterPath)
            )

            binding.img2.downloadAndSetImage(
                getString(
                    R.string.poster_base_url,
                    movieList.movies[viewModel.img2].posterPath)
            )

            binding.img1.setOnClickListener {
                viewModel.onMovieClicked(viewModel.img1)
                binding.points.text = getString(R.string.higher_lower_score, viewModel.score)

            }
            binding.img2.setOnClickListener {
                viewModel.onMovieClicked(viewModel.img2)
                binding.points.text = getString(R.string.higher_lower_score, viewModel.score)
            }
        })
    }
}
