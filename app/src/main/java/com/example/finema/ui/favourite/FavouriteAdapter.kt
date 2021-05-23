package com.example.finema.ui.favourite

import android.util.Log
import com.example.finema.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finema.models.databaseModels.MovieModel


class FavouriteAdapter(private val films: List<MovieModel>) :
    RecyclerView.Adapter<FavouriteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.favourite_movie_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewholder: ViewHolder, position: Int) {
        Log.d("gypsy", position.toString())
        viewholder.filmTitle?.text = films[position].title
        viewholder.rating?.text = films[position].rating
        viewholder.genre?.text = films[position].genres
    }

    override fun getItemCount() = films.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //        val imageMovie: ImageView = view.findViewById(R.id.imageMovie) as ImageView
        var filmTitle: TextView? = null
        var rating: TextView? = null
        var genre: TextView? = null

        init {
            filmTitle = view.findViewById(R.id.filmTitle)
            rating = view.findViewById(R.id.rating)
            genre = view.findViewById(R.id.genre)
        }
    }
}