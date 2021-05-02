package com.example.finema.ui.higherlower

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finema.databinding.HigherLowerFragmentBinding
import com.example.finema.models.TMDBMovie
import com.example.finema.ui.base.BaseFragment

class HigherLowerFragment: BaseFragment<HigherLowerViewModel, HigherLowerFragmentBinding>(), MovieAdapter.MovieViewHolder.Listener {
    private lateinit var viewModel : HigherLowerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HigherLowerViewModel::class.java)
        viewModel.init()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.i("TAG", "MESSAGE")
        binding = HigherLowerFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("TAG", "MESSAGE")

        binding.rvMoviesList.layoutManager = LinearLayoutManager(context)
        binding.rvMoviesList.adapter = viewModel.getMovie().value?.let { MovieAdapter(
            it,
            this
        ) }

        viewModel.getMovie().observe(viewLifecycleOwner, {
            binding.rvMoviesList.adapter = MovieAdapter(it, this)
        })
    }

    override fun onMovieClicked(position: Int) {
        val list: List<TMDBMovie?>? = viewModel.getMovie().value
        if(position==0)
        {
            if (list?.get(position)?.popularity!! >= list[position + 1]?.popularity!!)
            {
                val text = "Nice! {} points!"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, text, duration)
                toast.show()
                viewModel.refreshData()
            }
        }
        else if(position==1)
        {
            if (list?.get(position)?.popularity!! >= list[position - 1]?.popularity!!)
            {
                val text = "Nice! {} points!"
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, text, duration)
                toast.show()
                viewModel.refreshData()

            }
        }
    }

}