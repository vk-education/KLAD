package com.example.finema.ui.chooseFavourite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.finema.R
import com.example.finema.models.infinite.MovieDiscoverResult
import com.example.finema.util.downloadAndSetImageUrl
import com.google.android.material.card.MaterialCardView

class MovieAdapter(
    context: Context,
    private val listener: CharacterViewHolder.Listener,
) :
    PagingDataAdapter<MovieDiscoverResult, MovieAdapter.CharacterViewHolder>(CharacterComparator) {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterViewHolder {
        return CharacterViewHolder(
            layoutInflater.inflate(R.layout.nice, parent, false),
            listener
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class CharacterViewHolder(
        view: View,
        private val listener: Listener
    ) :
        RecyclerView.ViewHolder(view) {
        var filmTitle: TextView? = null
        var movieCard: MaterialCardView? = null
        var moviePoster: ImageView? = null

        interface Listener {
            fun onMovieClicked(index: Int)
        }

        fun bind(item: MovieDiscoverResult) {
            filmTitle?.text = item.title
            moviePoster?.downloadAndSetImageUrl(
                POSTER_BASE_URL + item.posterPath
            )
            movieCard?.setOnClickListener {
                listener.onMovieClicked(item.id)
            }
        }

        init {
            filmTitle = view.findViewById(R.id.tv_name)
            movieCard = view.findViewById(R.id.movie_title)
            moviePoster = view.findViewById(R.id.imageViewNice)
        }
    }

    object CharacterComparator : DiffUtil.ItemCallback<MovieDiscoverResult>() {
        override fun areItemsTheSame(oldItem: MovieDiscoverResult, newItem: MovieDiscoverResult) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: MovieDiscoverResult,
            newItem: MovieDiscoverResult
        ) =
            oldItem == newItem
    }

    companion object {
        const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"
    }
}
