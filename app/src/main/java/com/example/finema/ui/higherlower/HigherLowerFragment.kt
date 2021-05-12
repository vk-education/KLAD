package com.example.finema.ui.higherlower

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finema.R
import com.example.finema.api.MoviesApi
import com.example.finema.databinding.HigherLowerFragmentBinding
import com.example.finema.api.MoviesRepository
import com.example.finema.ui.base.BaseFragment

class HigherLowerFragment : BaseFragment<HigherLowerViewModel, HigherLowerFragmentBinding>(),
     MovieAdapter.MovieViewHolder.Listener{

    var add = 0
    private lateinit var factory: MoviesViewModelFactory
    private lateinit var layout : CustomGridLayoutManager
    private val application = Application()
    private val viewModel = HigherLowerViewModel(application = application)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HigherLowerFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layout = CustomGridLayoutManager(requireContext())
        factory = MoviesViewModelFactory(application)
        viewModel.getMovies()

        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            binding.recyclerViewMovies.also {
                it.layoutManager = layout
                it.setHasFixedSize(true)
                it.adapter = MovieAdapter(movies, this)
            }
        })

    }

    override fun onMovieClicked(position: Int) {
        when(position){
            add ->
                if (viewModel.movies.value?.movies?.get(position)?.popularity!!
                    >= viewModel.movies.value?.movies?.get(position + 1)?.popularity!!
                ) {
                    add += 1
                    binding.points.text = "Очки: $add"
                    layout.isScrollEnabled = true
                    binding.recyclerViewMovies.scrollToPosition(add + 1)
                    layout.isScrollEnabled = false

                } else {
                    add = 0
                    binding.points.text = "Очки: $add"
                    layout.isScrollEnabled = true
                    binding.recyclerViewMovies.scrollToPosition(0)
                    layout.isScrollEnabled = false
                }
        add+1 ->
                if (viewModel.movies.value?.movies?.get(position)?.popularity!!
                    >= viewModel.movies.value?.movies?.get(position - 1)?.popularity!!
                ) {
                    add += 1
                    binding.points.text = "Очки: $add"
                    layout.isScrollEnabled = true
                    binding.recyclerViewMovies.scrollToPosition(add + 1)
                    layout.isScrollEnabled = false

                } else {
                    add = 0
                    binding.points.text = "Очки: $add"
                    layout.isScrollEnabled = true
                    binding.recyclerViewMovies.scrollToPosition(0)
                    layout.isScrollEnabled = false
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
