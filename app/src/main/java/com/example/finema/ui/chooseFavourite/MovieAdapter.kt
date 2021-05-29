package com.example.finema.ui.chooseFavourite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.finema.R
import com.example.finema.models.databaseModels.GenreModel
import com.example.finema.models.infinite.MovieDiscoverResult
import com.example.finema.ui.favourite.FavouriteAdapter
import com.example.finema.ui.tournaments.genres.GenresTournamentAdapter

class MovieAdapter(
    context: Context,
    private val listener: CharacterViewHolder.Listener,
    )
    : PagingDataAdapter<MovieDiscoverResult, MovieAdapter.CharacterViewHolder>(CharacterComparator)  {

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
    )
        : RecyclerView.ViewHolder(view) {
        var filmTitle: TextView? = null

        interface Listener {
            fun onMovieClicked(index: Int)
        }

        fun bind(item: MovieDiscoverResult) {
            filmTitle?.text = item.title
            filmTitle?.setOnClickListener {
                listener.onMovieClicked(item.id)
            }
        }

        init {
            filmTitle = view.findViewById(R.id.movie_title)
        }
    }

    object CharacterComparator : DiffUtil.ItemCallback<MovieDiscoverResult>() {
        override fun areItemsTheSame(oldItem: MovieDiscoverResult, newItem: MovieDiscoverResult) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: MovieDiscoverResult, newItem: MovieDiscoverResult) =
            oldItem == newItem
    }
}