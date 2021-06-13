package com.example.finema.ui.userProfile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finema.R
import com.example.finema.models.databaseModels.TopModel
import com.example.finema.util.downloadAndSetImageUrl

class ProfileAdapter(
    private val listener: ProfileHolder.Listener
) : RecyclerView.Adapter<ProfileAdapter.ProfileHolder>() {
    var movies: List<TopModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.top_movie_item, parent, false)

        return ProfileHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ProfileHolder, position: Int) {
        holder.bind(position, movies)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class ProfileHolder(
        view: View,
        private val listener: Listener
    ) : RecyclerView.ViewHolder(view) {

        private val movieName: TextView = view.findViewById(R.id.top_title)
        private val moviePoster: ImageView = view.findViewById(R.id.posterTop)

        interface Listener {
            fun onMovieClicked(movie: TopModel)
        }

        fun bind(position: Int, listMovie: List<TopModel>) {
            movieName.text = listMovie[position].title
            moviePoster.downloadAndSetImageUrl(
                POSTER_BASE_URL + listMovie[adapterPosition].imageUrl
            )
            itemView.setOnClickListener {
                listener.onMovieClicked(listMovie[adapterPosition])
            }
        }
    }

    companion object {
        const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"
    }
}
