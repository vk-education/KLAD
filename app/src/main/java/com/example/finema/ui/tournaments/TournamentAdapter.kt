package com.example.finema.ui.tournaments

import android.app.Dialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finema.R
import com.example.finema.models.databaseModels.GenreModel

class TournamentAdapter : RecyclerView.Adapter<TournamentAdapter.TournamentHolder>() {

    private var mListGenres = emptyList<GenreModel>()
    private lateinit var dialog: Dialog

    class TournamentHolder(view: View) : RecyclerView.ViewHolder(view) {
        val genreName: TextView = view.findViewById(R.id.item_genre_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.genre_item, parent, false)
        dialog = Dialog(view.context)
        dialog.setContentView(R.layout.number_fragment)
        return TournamentHolder(view)
    }

    override fun onBindViewHolder(holder: TournamentHolder, position: Int) {
        holder.genreName.text = mListGenres[position].name
    }

    override fun getItemCount(): Int = mListGenres.size


    fun setList(list: List<GenreModel>) {
        mListGenres = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: TournamentHolder) {
        holder.itemView.setOnClickListener {
            val genreClickedItem = mListGenres[holder.adapterPosition]
            val btn16: TextView = dialog.findViewById(R.id.btn16)
            val btn8: TextView = dialog.findViewById(R.id.btn8)
            dialog.show()
            btn16.setOnClickListener {
                TournamentGenresFragment.click(genreClickedItem, 16)
                dialog.hide()
            }
            btn8.setOnClickListener {
                TournamentGenresFragment.click(genreClickedItem, 8)
                dialog.hide()
            }

        }
    }

}