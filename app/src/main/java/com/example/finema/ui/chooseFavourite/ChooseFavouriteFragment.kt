package com.example.finema.ui.chooseFavourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finema.R
import com.example.finema.databinding.ChooseFavouriteFragmentBinding
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.hideKeyboard
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.getViewModel

class ChooseFavouriteFragment :
    BaseFragment<ChooseFavouriteViewModel, ChooseFavouriteFragmentBinding>(),
    MovieAdapter.CharacterViewHolder.Listener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ChooseFavouriteFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        viewModel = getViewModel()
        super.onViewCreated(view, savedInstanceState)

        val adapterMovs = MovieAdapter(this)

        binding.movs.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterMovs
        }

        binding.query.doAfterTextChanged { text ->
            viewModel.setQuery(text?.toString() ?: "")
        }

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.movies.collectLatest { pagingData ->
                adapterMovs.submitData(pagingData)
            }
        }
    }

    override fun onMovieClicked(index: Int) {
        goDetailsFragment(index.toLong())
        binding.query.hideKeyboard()
    }

    private fun goDetailsFragment(filmIdInfo: Long) {
        val bundle = Bundle()
        bundle.putSerializable("filmId", filmIdInfo)
        Navigation.findNavController(requireActivity(), R.id.fragment)
            .navigate(R.id.action_chooseFavouriteFragment_to_fragmentFilm, bundle)
    }
}
