package com.example.finema.ui.chooseFavourite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.finema.R
import com.example.finema.models.infinite.MovieDiscoverResult
import com.example.finema.ui.favourite.FavouriteAdapter

class MovieAdapter(context: Context) :
    PagingDataAdapter<MovieDiscoverResult, MovieAdapter.CharacterViewHolder>(CharacterComparator)  {

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterViewHolder {
        return CharacterViewHolder(layoutInflater.inflate(R.layout.nice, parent, false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var filmTitle: TextView? = null

        fun bind(item: MovieDiscoverResult) {
            filmTitle?.text = item.name
        }

        init {
            filmTitle = view.findViewById(R.id.tv_name)
        }
    }

    object CharacterComparator : DiffUtil.ItemCallback<MovieDiscoverResult>() {
        override fun areItemsTheSame(oldItem: MovieDiscoverResult, newItem: MovieDiscoverResult) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: MovieDiscoverResult, newItem: MovieDiscoverResult) =
            oldItem == newItem
    }
}