package com.example.finema.ui.tournaments.categories

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.finema.R
import com.example.finema.databinding.FragmentCategoryTournamentBinding
import com.example.finema.models.databaseModels.CategoryModel
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.ui.base.BaseFragment
import com.example.finema.ui.tournaments.genres.GenresTournamentAdapter
import com.example.finema.ui.tournaments.genres.GenresTournamentVM
import com.example.finema.util.APP_ACTIVITY
import com.example.finema.util.AppPreference
import org.koin.androidx.viewmodel.ext.android.getViewModel

class CategoryTournamentFragment(
) :
    BaseFragment<CategoryTournamentVM, FragmentCategoryTournamentBinding>(),
    CategoryTournamentAdapter.TournamentHolder.Listener {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: CategoryTournamentAdapter
    private lateinit var mObserverList: Observer<List<CategoryModel>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryTournamentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }

    private fun initialization() {
        mAdapter = CategoryTournamentAdapter(this)
        mRecyclerView = binding.categoryRecycler
        mRecyclerView.adapter = mAdapter
        mObserverList = Observer {
            val list = it
            mAdapter.setList(list)
        }
        viewModel.allCategories.observe(APP_ACTIVITY, mObserverList)

    }

    override fun onMovieClicked(view: View, categoryModel: CategoryModel) {
        dialogBinding(categoryModel.link, categoryModel.name)
    }

    private fun dialogBinding(link: String, categoryName: String) {
        //TODO Изменить на фрагмент
        val dialog = Dialog(requireContext())
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.let {
            it.setContentView(R.layout.number_fragment)
            it.findViewById<View>(R.id.btn8).setOnClickListener {
                goNextFragment(8, link, categoryName)
                dialog.hide()
            }

            it.findViewById<View>(R.id.btn16).setOnClickListener {
                goNextFragment(16, link,categoryName)
                dialog.hide()
            }

        }
        dialog.show()
    }

    private fun goNextFragment(num: Int, link: String,categoryName: String) {
        AppPreference.setNumOfFilms(num)
        AppPreference.setCategoryName(categoryName)
        AppPreference.setCategoryLink(link.toInt())
        Navigation.findNavController(APP_ACTIVITY, R.id.fragment)
            .navigate(R.id.action_fragmentOthers_to_fragmentTournament)
    }

}