package com.example.finema.ui.tournaments.tournament

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.asFlow
import com.example.finema.R
import com.example.finema.databinding.FragmentTournamentBinding
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.APP_ACTIVITY
import com.example.finema.util.downloadAndSetImageUrl
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.getViewModel

class TournamentFragment : BaseFragment<TournamentVM, FragmentTournamentBinding>() {

    private lateinit var desc: TextView

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
        viewModel.twoFilms.observe(APP_ACTIVITY, { movieList ->

            binding.txtFilm1.text = movieList[0].title
            binding.txtFilm2.text = movieList[1].title

            binding.img1.downloadAndSetImageUrl(
                getString(
                    R.string.poster_base_url,
                    movieList[0].posterPath
                )
            )
            binding.img2.downloadAndSetImageUrl(
                getString(
                    R.string.poster_base_url,
                    movieList[1].posterPath
                )
            )

            binding.progressBar.visibility = View.GONE
            binding.cardview1.visibility = View.VISIBLE
            binding.cardview2.visibility = View.VISIBLE

            binding.txtNumCategory.text = viewModel.title
            binding.roundCount.text = "Раунд ${viewModel.roundCount}"

            binding.cardview1.setOnClickListener {
                viewModel.itemClick(0)
                resetBookmarks()
            }

            binding.cardview2.setOnClickListener {
                viewModel.itemClick(1)
                resetBookmarks()
            }

            binding.more1.setOnClickListener {
                dialogBinding(0)
            }

            binding.more2.setOnClickListener {
                dialogBinding(1)
            }

            CoroutineScope(Dispatchers.Main).launch {
                viewModel.favouriteMovies.asFlow().collectLatest {
                    for(i in it) {
                        if(binding.txtFilm1.text == i.title) {
                            binding.bookmark1.setImageResource(R.drawable.bookmark_24)
                            binding.bookmark1.tag = "bruh"
                        }
                        if(binding.txtFilm2.text == i.title) {
                            binding.bookmark2.setImageResource(R.drawable.bookmark_24)
                            binding.bookmark2.tag = "bruh"
                        }
                    }
                }
            }

        })

        binding.bookmark1.setOnClickListener {
            setBookmarks(binding.bookmark1, 0)
        }

        binding.bookmark2.setOnClickListener {
            setBookmarks(binding.bookmark2, 1)
        }
    }

    private fun dialogBinding(index: Int) {
        val dialog = Dialog(requireContext())
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.let {
            it.setContentView(R.layout.movie_description)
            desc = it.findViewById(R.id.desc)
            if(viewModel.returnDesc(index) == "") {
                desc.text = "Пусто"
            } else {
                desc.text = viewModel.returnDesc(index)
            }
        }
        dialog.show()
    }

    private fun resetBookmarks() {
        binding.bookmark1.setImageResource(R.drawable.bookmark_border_24)
        binding.bookmark2.setImageResource(R.drawable.bookmark_border_24)
        binding.bookmark1.tag = ""
        binding.bookmark2.tag = ""
    }

    private fun setBookmarks(bookmark: ImageButton, position: Int) {
        if(bookmark.tag == "bruh") {
            animateBookmark(bookmark)

            Toast.makeText(context, "Удалено из избранные", Toast.LENGTH_SHORT).show()
            bookmark.setImageResource(R.drawable.bookmark_border_24)
            viewModel.removeFromFav(position)

            bookmark.tag = "b"
        } else {
            animateBookmark(bookmark)

            Toast.makeText(context, "Добавлено в избранные", Toast.LENGTH_SHORT).show()
            bookmark.setImageResource(R.drawable.bookmark_24)
            viewModel.addToFav(position)

            bookmark.tag = "bruh"
        }

    }

    private fun animateBookmark(bookmark: ImageButton) {
        bookmark.animate().apply {
            duration = 250
            scaleXBy(1f)
            scaleYBy(1f)
        }.withEndAction {
            bookmark.animate().apply {
                duration = 250
                scaleXBy(-1f)
                scaleYBy(-1f)
            }
        }
    }

}




