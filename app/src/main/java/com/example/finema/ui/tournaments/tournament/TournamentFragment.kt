package com.example.finema.ui.tournaments.tournament

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import com.example.finema.R
import com.example.finema.databinding.FragmentTournamentBinding
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.APP_ACTIVITY
import com.example.finema.util.downloadAndSetImage
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.properties.Delegates

class TournamentFragment : BaseFragment<TournamentVM, FragmentTournamentBinding>() {

    private var numFilms by Delegates.notNull<Int>()
    private lateinit var genreFilm: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTournamentBinding
            .inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()

        super.onViewCreated(view, savedInstanceState)
        // get number from previous fragment
        numFilms = arguments?.getSerializable("num") as Int
        genreFilm = arguments?.getSerializable("genre") as String

        viewModel.twoFilms.observe(APP_ACTIVITY, {

            binding.txtFilm1.text = it[0].title
            binding.txtFilm2.text = it[1].title

            binding.img1.downloadAndSetImage(
                getString(
                    R.string.poster_base_url,
                    it[0].posterPath
                )
            )
            binding.img2.downloadAndSetImage(
                getString(
                    R.string.poster_base_url,
                    it[1].posterPath
                )
            )

            binding.progressBar.visibility = View.GONE
            binding.cardview1.visibility = View.VISIBLE
            binding.cardview2.visibility = View.VISIBLE

            binding.txtNumCategory.text = "$numFilms Лучших фильмов"
            binding.roundCount.text = "Раунд ${viewModel.roundCount}"

            binding.cardview1.setOnClickListener {
                viewModel.itemClick(0)
                resetBookmarks()
            }

            binding.cardview2.setOnClickListener {
                viewModel.itemClick(1)
                resetBookmarks()
            }
        })

        binding.bookmark1.setOnClickListener {
            Toast.makeText(context, "Логики нет", Toast.LENGTH_SHORT).show()
            setBookmarks(binding.bookmark1, 0)
        }

        binding.bookmark2.setOnClickListener {
            Toast.makeText(context, "Логики нет", Toast.LENGTH_SHORT).show()
            setBookmarks(binding.bookmark2, 1)
            viewModel
        }
    }

    private fun resetBookmarks() {
        binding.bookmark1.setImageResource(R.drawable.bookmark_border_24)
        binding.bookmark2.setImageResource(R.drawable.bookmark_border_24)
        binding.bookmark1.tag = ""
        binding.bookmark2.tag = ""
    }

    private fun setBookmarks(bookmark: ImageButton, position: Int) {
        if(bookmark.tag == "bruh") {
            bookmark.setImageResource(R.drawable.bookmark_border_24)
            viewModel.removeFromFav(position)
            bookmark.tag = "b"
        } else {
            bookmark.setImageResource(R.drawable.bookmark_24)
            viewModel.addToFav(position)
            bookmark.tag = "bruh"
        }

    }

}




