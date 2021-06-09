package com.example.finema.ui.tournaments.genres

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.finema.R
import com.example.finema.databinding.FragmentTournamentGenresBinding
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.models.genreRequest.GenreList
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.AppPreference
import org.koin.androidx.viewmodel.ext.android.getViewModel

class GenresTournamentFragment :
    BaseFragment<GenresTournamentVM, FragmentTournamentGenresBinding>(),
    GenresTournamentAdapter.TournamentHolder.Listener {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: GenresTournamentAdapter
    private lateinit var mObserverList: Observer<List<GenreModel>>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTournamentGenresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }

    private fun initialization() {
        if (!viewModel.checkDatabaseNotEmpty()) loadGenresList()

        mAdapter = GenresTournamentAdapter(this)
        mRecyclerView = binding.tournamentsRecycler
        mRecyclerView.adapter = mAdapter

        mObserverList = Observer {
            mAdapter.setList(it)
        }
        // TODO Убрать получение и обращаться к VM базового класса
        viewModel.allGenres.observe(requireActivity(), mObserverList)
    }

    // TODO genreModel -> {} : GenreModel -> Unit
    // Заменить на лямбду, хз так ли написал выше
    override fun onMovieClicked(view: View, genreModelId: GenreModel) {
        if (genreModelId.id == GENRE_NOT_FOUND_TEMPORARILY) {
            Toast.makeText(context, "Этот жанр временно отсутсвует", Toast.LENGTH_SHORT).show()
        } else {
            dialogBinding(genreModelId.id.toString(), genreModelId.name)
        }
    }

    private fun dialogBinding(genreId: String, genreName: String) {
        val dialog = Dialog(requireContext())
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.let {
            it.setContentView(R.layout.number_fragment)
            it.findViewById<View>(R.id.btn8).setOnClickListener {
                goNextFragment(PRESSED_EIGHT_MOVIES, genreId, genreName)
                dialog.onBackPressed()
            }
            it.findViewById<View>(R.id.btn16).setOnClickListener {
                goNextFragment(PRESSED_SIXTEEN_MOVIES, genreId, genreName)
                dialog.onBackPressed()
            }
            it.findViewById<View>(R.id.btn32).setOnClickListener {
                goNextFragment(PRESSED_THIRTY_TWO_MOVIES, genreId, genreName)
                dialog.onBackPressed()
            }
            it.findViewById<View>(R.id.btn64).setOnClickListener {
                goNextFragment(PRESSED_SIXTY_FOUR_MOVIES, genreId, genreName)
                dialog.onBackPressed()
            }
            it.findViewById<View>(R.id.btn128).setOnClickListener {
                goNextFragment(PRESSED_ONE_HUNDRED_AND_TWENTY_EIGHT_MOVIES, genreId, genreName)
                dialog.onBackPressed()
            }
            it.findViewById<View>(R.id.btn256).setOnClickListener {
                goNextFragment(PRESSED_TWO_HUNDRED_AND_FIFTY_SIX_MOVIES, genreId, genreName)
                dialog.onBackPressed()
            }
        }
        dialog.show()
    }

    private fun goNextFragment(num: Int, genreId: String, genreName: String) {
        AppPreference.setNumOfFilms(num)
        AppPreference.setGenreName(genreName)
        AppPreference.setGenre(genreId)

        Navigation.findNavController(requireActivity(), R.id.fragment)
            .navigate(R.id.action_fragmentGenre_to_fragmentTournament)
    }

    private fun loadGenresList() {
        val mObserverList: Observer<GenreList> = Observer {
            val list = it.genres
            for (item in list) {
                viewModel.insert(GenreModel(name = item.name, id = item.id))
            }
        }

        viewModel.getGenres()

        viewModel.genreListVM.observe(viewLifecycleOwner, mObserverList)
    }

    companion object {
        const val GENRE_NOT_FOUND_TEMPORARILY = 99
        const val PRESSED_EIGHT_MOVIES = 8
        const val PRESSED_SIXTEEN_MOVIES = 16
        const val PRESSED_THIRTY_TWO_MOVIES = 32
        const val PRESSED_SIXTY_FOUR_MOVIES = 64
        const val PRESSED_ONE_HUNDRED_AND_TWENTY_EIGHT_MOVIES = 128
        const val PRESSED_TWO_HUNDRED_AND_FIFTY_SIX_MOVIES = 256
    }
}
