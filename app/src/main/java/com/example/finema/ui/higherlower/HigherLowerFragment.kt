package com.example.finema.ui.higherlower

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
    var add2 = 1
    private lateinit var factory: MoviesViewModelFactory
    private lateinit var layout : CustomGridLayoutManager
    private val api = MoviesApi()
    private val repository = MoviesRepository(api)
    private val viewModel = HigherLowerViewModel(repository)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.higher_lower_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        layout = CustomGridLayoutManager(requireContext())
        factory = MoviesViewModelFactory(repository)

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
        if (position == add) {
            if (viewModel.movies.value?.movies?.get(position)?.popularity!!
                >= viewModel.movies.value?.movies?.get(position + 1)?.popularity!!
            ) {
                add += 1
                add2 += 1
                val text = "Nice! {$add} points!"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, text, duration)
                toast.show()
                layout.setScrollEnabled(true)
                binding.recyclerViewMovies.scrollToPosition(add + 1)
                layout.setScrollEnabled(false)
            } else {
                val text = "WRONG"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, text, duration)
                toast.show()
                add = 0
                add2 = 1
                layout.setScrollEnabled(true)
                binding.recyclerViewMovies.scrollToPosition(0)
                layout.setScrollEnabled(false)
            }
        } else if (position == add2) {
            if (viewModel.movies.value?.movies?.get(position)?.popularity!!
                >= viewModel.movies.value?.movies?.get(position - 1)?.popularity!!
            ) {
                val text = "Nice! {$add} points!"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, text, duration)
                toast.show()
                add += 1
                add2 += 1
                layout.setScrollEnabled(true)
                binding.recyclerViewMovies.scrollToPosition(add2)
                layout.setScrollEnabled(false)
            } else {
                val text = "WRONG"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, text, duration)
                toast.show()
                add = 0
                add2 = 1
                layout.setScrollEnabled(true)
                binding.recyclerViewMovies.scrollToPosition(0)
                layout.setScrollEnabled(false)

            }
        }
    }
}

class CustomGridLayoutManager(context: Context?) : LinearLayoutManager(context) {
    private var isScrollEnabled = false

    fun setScrollEnabled(flag: Boolean) {
        isScrollEnabled = flag
    }

    override fun canScrollVertically(): Boolean {
        //Similarly you can customize "canScrollHorizontally()" for managing horizontal scroll
        return isScrollEnabled && super.canScrollVertically()
    }
}
