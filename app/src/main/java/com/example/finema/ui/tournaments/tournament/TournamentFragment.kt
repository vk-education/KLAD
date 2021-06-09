package com.example.finema.ui.tournaments.tournament

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import com.example.finema.R
import com.example.finema.databinding.FragmentTournamentBinding
import com.example.finema.models.movieResponse.Movie
import com.example.finema.ui.base.BaseFragment
import com.example.finema.util.APP_ACTIVITY
import com.example.finema.util.downloadAndSetImageUrl
import org.koin.androidx.viewmodel.ext.android.getViewModel

class TournamentFragment : BaseFragment<TournamentVM, FragmentTournamentBinding>() {

    private lateinit var desc: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTournamentBinding
            .inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = getViewModel()

        super.onViewCreated(view, savedInstanceState)
        viewModel.twoFilms.observe(
            requireActivity(),
            { movieList ->

                binding.txtFilm1.text = movieList[0].title
                binding.txtFilm2.text = movieList[1].title

                binding.progressBar.visibility = View.GONE
                binding.cardview1.visibility = View.VISIBLE
                binding.cardview2.visibility = View.VISIBLE

                setImage(binding.img1, movieList, 0)
                setImage(binding.img2, movieList, 1)

                binding.txtNumCategory.text = viewModel.title
                binding.roundCount.text = getString(R.string.n_round, viewModel.roundCount)

                cardClickListener(binding.cardview1, 0)
                cardClickListener(binding.cardview2, 1)

                infoClicked(binding.more1, 0)
                infoClicked(binding.more2, 1)

                fillInBookmarks(binding.txtFilm1, binding.bookmark1)
                fillInBookmarks(binding.txtFilm2, binding.bookmark2)
            }
        )
        setBookmarkClickListeners(binding.bookmark1, binding.txtFilm1, 0)
        setBookmarkClickListeners(binding.bookmark2, binding.txtFilm2, 1)
    }

    private fun fillInBookmarks(txtview: TextView, bookmark: ImageButton) {
        viewModel.favouriteMovies.observe(
            viewLifecycleOwner,
            {
                var counter = 0
                for (i in it) {
                    counter += 1
                    if (txtview.text == i.title) {
                        bookmark.setImageResource(
                            R.drawable.bookmark_24
                        )
                        break
                    }
                    if (counter == it.size) {
                        bookmark.setImageResource(
                            R.drawable.bookmark_border_24
                        )
                    }
                }
            }
        )
    }

    private fun infoClicked(button: ImageButton, position: Int) {
        button.setOnClickListener {
            dialogBinding(position)
        }
    }

    private fun cardClickListener(cardView: CardView, position: Int) {
        cardView.setOnClickListener {
            viewModel.itemClick(position)
        }
    }

    private fun setImage(image: ImageView, movieList: List<Movie>, imgInd: Int) {
        image.downloadAndSetImageUrl(
            getString(
                R.string.poster_base_url,
                movieList[imgInd].posterPath
            )
        )
    }

    private fun setBookmarkClickListeners(bookmark: ImageButton, title: TextView, position: Int) {
        bookmark.setOnClickListener {
            animateBookmark(bookmark)
            addODelFav(title, position)
        }
    }

    private fun dialogBinding(index: Int) {
        val dialog = Dialog(requireContext())
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.let {
            it.setContentView(R.layout.movie_description)
            desc = it.findViewById(R.id.desc)
            if (viewModel.returnDesc(index) == "") {
                desc.text = "Пусто"
            } else {
                desc.text = viewModel.returnDesc(index)
            }
        }
        dialog.show()
    }

    private fun addODelFav(title: TextView, position: Int) {
        viewModel.favouriteMovies.value?.let {
            var counter = 0
            for (i in it) {
                counter += 1
                if (title.text == i.title || title.text == i.originalTitle) {
                    viewModel.removeFromFav(position)
                    break
                }
                if (it.size == counter) {
                    viewModel.addToFav(position)
                }
            }
        }
    }

    private fun animateBookmark(bookmark: ImageButton) {
        bookmark.animate().apply {
            duration = ANIMATION_DURATION
            scaleXBy(ANIMATION_ROTATION)
            scaleYBy(ANIMATION_ROTATION)
        }.withEndAction {
            bookmark.animate().apply {
                duration = ANIMATION_DURATION
                scaleXBy(-ANIMATION_ROTATION)
                scaleYBy(-ANIMATION_ROTATION)
            }
        }
    }

    companion object {
        private const val ANIMATION_DURATION = 250L
        private const val ANIMATION_ROTATION = 1f
    }
}
