package com.example.finema.ui.tournaments.categories

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.finema.R
import com.example.finema.databinding.FragmentCategoryTournamentBinding
import com.example.finema.models.databaseModels.CategoryModel
import com.example.finema.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.getViewModel

class CategoryTournamentFragment :
    BaseFragment<CategoryTournamentVM, FragmentCategoryTournamentBinding>(),
    CategoryTournamentAdapter.TournamentHolder.Listener {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: CategoryTournamentAdapter
    private lateinit var mObserverList: Observer<List<CategoryModel>>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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
        viewModel.allCategories.observe(requireActivity(), mObserverList)
    }

    override fun onMovieClicked(view: View, categoryModel: CategoryModel) {
        if (categoryModel.link == CATEGORY_WARNING) {
            warningDialog(categoryModel.link, categoryModel.name)
        } else dialogBinding(categoryModel.link, categoryModel.name)
    }

    private fun warningDialog(link: String, categoryName: String) {
        val builder = AlertDialog.Builder(requireContext())
        builder.apply {
            setTitle("Эта категория Содержит контент 18+")
            builder.setMessage("Продолжить?")
            setPositiveButton("Да") { _, _ ->
                dialogBinding(link, categoryName)
            }
            setNegativeButton("Нет") { dialog, _ ->
                dialog.cancel()
            }
        }
        builder.create()
        builder.show()
    }

    private fun dialogBinding(link: String, categoryName: String) {
        // TODO Изменить на фрагмент
        val dialog = Dialog(requireContext())
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.let {
            it.setContentView(R.layout.number_fragment)
            it.findViewById<View>(R.id.btn8).setOnClickListener {
                goNextFragment(PRESSED_EIGHT_MOVIES, link, categoryName)
                dialog.onBackPressed()
            }

            it.findViewById<View>(R.id.btn16).setOnClickListener {
                goNextFragment(PRESSED_SIXTEEN_MOVIES, link, categoryName)
                dialog.onBackPressed()
            }
            it.findViewById<View>(R.id.btn32).setOnClickListener {
                goNextFragment(PRESSED_THIRTY_TWO_MOVIES, link, categoryName)
                dialog.onBackPressed()
            }
            it.findViewById<View>(R.id.btn64).setOnClickListener {
                goNextFragment(PRESSED_SIXTY_FOUR_MOVIES, link, categoryName)
                dialog.onBackPressed()
            }
            it.findViewById<View>(R.id.btn128).setOnClickListener {
                goNextFragment(PRESSED_ONE_HUNDRED_AND_TWENTY_EIGHT_MOVIES, link, categoryName)
                dialog.onBackPressed()
            }
            it.findViewById<View>(R.id.btn256).setOnClickListener {
                goNextFragment(PRESSED_TWO_HUNDRED_AND_FIFTY_SIX_MOVIES, link, categoryName)
                dialog.onBackPressed()
            }
        }
        dialog.show()
    }

    private fun goNextFragment(num: Int, link: String, categoryName: String) {
        viewModel.setParameters(num, categoryName, link)
        Navigation.findNavController(requireActivity(), R.id.fragment)
            .navigate(R.id.action_fragmentOthers_to_fragmentTournament)
    }

    companion object {
        const val PRESSED_EIGHT_MOVIES = 8
        const val PRESSED_SIXTEEN_MOVIES = 16
        const val PRESSED_THIRTY_TWO_MOVIES = 32
        const val PRESSED_SIXTY_FOUR_MOVIES = 64
        const val PRESSED_ONE_HUNDRED_AND_TWENTY_EIGHT_MOVIES = 128
        const val PRESSED_TWO_HUNDRED_AND_FIFTY_SIX_MOVIES = 256
        const val CATEGORY_WARNING = "133"
    }
}
