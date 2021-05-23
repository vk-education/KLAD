package com.example.finema.ui.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finema.databinding.FavouriteFragmentBinding
import com.example.finema.models.databaseModels.MovieModel
import com.example.finema.ui.base.BaseFragment
import com.example.finema.ui.tournaments.genres.GenresTournamentAdapter
import org.koin.androidx.viewmodel.ext.android.getViewModel

class FavouriteFragment : BaseFragment<FavouriteViewModel, FavouriteFragmentBinding>() {

    val list = listOf(460465, 567189, 399566, 578701)

    private lateinit var adapter: FavouriteAdapter
    private var movies: List<MovieModel>? = listOf()
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FavouriteFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()
        super.onViewCreated(view, savedInstanceState)

        viewModel.favouriteMovies.observe(viewLifecycleOwner, {
            if (it != null){
                binding.searchLoader.visibility = View.INVISIBLE
                binding.moviesList.visibility = View.VISIBLE
                binding.moviesList.layoutManager = LinearLayoutManager(context)
                binding.moviesList.adapter = FavouriteAdapter(it)
            }

        })

    }

}
