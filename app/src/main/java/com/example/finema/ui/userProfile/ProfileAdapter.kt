package com.example.finema.ui.userProfile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finema.R
import com.example.finema.models.databaseModels.TopModel

class ProfileAdapter(
    private val listener: ProfileHolder.Listener
) : RecyclerView.Adapter<ProfileAdapter.ProfileHolder>()
{
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

        interface Listener {
            fun onMovieClicked(movie: TopModel)
        }

        fun bind(position: Int, listMovie: List<TopModel>) {
            movieName.text = listMovie[position].title
            itemView.setOnClickListener {
                listener.onMovieClicked(listMovie[adapterPosition])
            }

        }

    }
    
}
