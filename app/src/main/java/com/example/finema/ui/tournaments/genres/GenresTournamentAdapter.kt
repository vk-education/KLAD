package com.example.finema.ui.tournaments.genres

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finema.R
import com.example.finema.models.databaseModels.GenreModel

class GenresTournamentAdapter(
    private val listener: TournamentHolder.Listener,
) : RecyclerView.Adapter<GenresTournamentAdapter.TournamentHolder>() {

    private var mListGenres = emptyList<GenreModel>()

    fun setList(list: List<GenreModel>) {
        mListGenres = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.genre_item, parent, false)
        return TournamentHolder(view, listener)
    }

    override fun onBindViewHolder(holder: TournamentHolder, position: Int) {
        holder.bind(mListGenres[position].name, mListGenres)
    }

    override fun getItemCount(): Int = mListGenres.size

    class TournamentHolder(
        view: View,
        private val listener: Listener
    ) : RecyclerView.ViewHolder(view) {

        private val genreName: TextView = view.findViewById(R.id.item_genre_name)

        interface Listener {
            fun onMovieClicked(view: View, genreModelId: GenreModel)
        }

        fun bind(name: String, mListGenres: List<GenreModel>) {
            genreName.text = name
            itemView.setOnClickListener {
                listener.onMovieClicked(itemView, mListGenres[adapterPosition])
            }
        }
    }
}
