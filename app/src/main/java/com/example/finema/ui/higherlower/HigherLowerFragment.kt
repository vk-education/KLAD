package com.example.finema.ui.higherlower

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.finema.databinding.HigherLowerFragmentBinding
import com.example.finema.ui.base.BaseFragment
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.getViewModel


//TODO Убрать ресайклер
class HigherLowerFragment : BaseFragment<HigherLowerViewModel, HigherLowerFragmentBinding>() {

    var add = 0

    companion object{
        const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"
    }

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

        viewModel.movies.observe(viewLifecycleOwner, { movies ->
            binding.txtFilm1.text = movies.movies[add].title
            binding.txtFilm2.text = movies.movies[add+1].title

            Glide
                .with(binding.root)
                .load(POSTER_BASE_URL + movies.movies[add].posterPath)
                .into(binding.img1)
            Glide
                .with(binding.root)
                .load(POSTER_BASE_URL + movies.movies[add+1].posterPath)
                .into(binding.img2)

            binding.img1.setOnClickListener {
                onMovieClicked(add)
            }
            binding.img2.setOnClickListener {
                onMovieClicked(add+1)
            }

        })

    }


    //TODO убрать во VM
    private fun onMovieClicked(position: Int) {
        when(position){
            add ->
                if (viewModel.movies.value?.movies?.get(position)?.popularity!!
                    >= viewModel.movies.value?.movies?.get(position + 1)?.popularity!!
                ) {
                    add += 1
                    binding.points.text = "Очки: $add"
                    viewModel.clickedRight()
                } else {
                    add = 0
                    binding.points.text = "Очки: $add"
                    viewModel.clickedWrong()
                }
        add+1 ->
                if (viewModel.movies.value?.movies?.get(position)?.popularity!!
                    >= viewModel.movies.value?.movies?.get(position - 1)?.popularity!!
                ) {
                    add += 1
                    binding.points.text = "Очки: $add"
                    viewModel.clickedRight()
                } else {
                    add = 0
                    binding.points.text = "Очки: $add"
                    viewModel.clickedWrong()
                }
        }
    }
}

class CustomGridLayoutManager(context: Context?) : LinearLayoutManager(context) {
    var isScrollEnabled = false

    override fun canScrollVertically(): Boolean {
        //Similarly you can customize "canScrollHorizontally()" for managing horizontal scroll
        return isScrollEnabled && super.canScrollVertically()
    }

}
