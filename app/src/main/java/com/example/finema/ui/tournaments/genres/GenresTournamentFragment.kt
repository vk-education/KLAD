package com.example.finema.ui.tournaments.genres

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.finema.R
import com.example.finema.databinding.FragmentTournamentGenresBinding
import com.example.finema.models.GenreRequest.GenreList
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.APP_ACTIVITY
import com.example.finema.util.AppPreference
import org.koin.androidx.scope.scopeActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class GenresTournamentFragment(
) :
    BaseFragment<GenresTournamentVM, FragmentTournamentGenresBinding>(),
    GenresTournamentAdapter.TournamentHolder.Listener {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: GenresTournamentAdapter
    private lateinit var mObserverList: Observer<List<GenreModel>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
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
        if (!AppPreference.getGeneratedGenres()) {
            loadGenresList()
        }

        mAdapter = GenresTournamentAdapter(this)
        mRecyclerView = binding.tournamentsRecycler
        mRecyclerView.adapter = mAdapter

        mObserverList = Observer {
            mAdapter.setList(it)
        }
        //TODO Убрать получение и обращаться к VM базового класса
        viewModel.allGenres.observe(APP_ACTIVITY, mObserverList)


    }

    //TODO genreModel -> {} : GenreModel -> Unit
    // Заменить на лямбду, хз так ли написал выше
    override fun onMovieClicked(view: View, genreModel: GenreModel) {
        dialogBinding(genreModel.id.toString())
    }

    private fun dialogBinding(genre: String) {
        //TODO Изменить на фрагмент
        //TODO Заменить на нормальный контекст
        val dialog = Dialog(requireContext())

        //TODO Dialog(APP_ACTIVITY).let {
        //            it.setContentView(R.layout.number_fragment)
        //            it.findViewById<View>(R.id.btn8).setOnClickListener { _ ->
        //                goNext(8, list1)
        //                it.hide()
        //            }
        //        }

        dialog.setContentView(R.layout.number_fragment)

        val btn8: TextView = dialog.findViewById(R.id.btn8)
        val btn16: Button = dialog.findViewById(R.id.btn16)

        btn8.setOnClickListener {
            goNextFragment(8, genre)
            dialog.hide()
        }
        btn16.setOnClickListener {
            goNextFragment(16, genre)
            dialog.hide()
        }
        dialog.show()
    }

    private fun goNextFragment(num: Int, genre: String) {
        val bundle = Bundle()
        bundle.putSerializable("num", num)
        bundle.putSerializable("genre", genre)
//        TODO FragmentGenreDestinations.action(_, _, _)
//        TODO findNavController() ?
        Navigation.findNavController(APP_ACTIVITY, R.id.fragment)
            .navigate(R.id.action_fragmentGenre_to_fragmentTournament, bundle)
    }

    private fun loadGenresList() {
        val mObserverList: Observer<GenreList> = Observer {
            val list = it.genres
            for (item in list) {
                viewModel.insert(GenreModel(name = item.name, id = item.id))
            }
        }

        viewModel.getGenres {
            AppPreference.setGeneratedGenres(true)
        }

        viewModel.genreListVM.observe(viewLifecycleOwner, mObserverList)
    }
}
