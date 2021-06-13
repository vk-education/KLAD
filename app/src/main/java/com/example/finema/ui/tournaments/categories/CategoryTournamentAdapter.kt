package com.example.finema.ui.tournaments.categories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finema.R
import com.example.finema.models.databaseModels.CategoryModel

class CategoryTournamentAdapter(
    private val listener: TournamentHolder.Listener,
) : RecyclerView.Adapter<CategoryTournamentAdapter.TournamentHolder>() {

    private var mListCategories = emptyList<CategoryModel>()

    class TournamentHolder(
        view: View,
        private val listener: Listener
    ) : RecyclerView.ViewHolder(view) {

        private val categoryName: TextView = view.findViewById(R.id.item_category_name)
        private val categoryDescription: TextView = view.findViewById(
            R.id.item_category_description
        )

        interface Listener {
            fun onMovieClicked(view: View, categoryModel: CategoryModel)
        }

        fun bind(name: String, description: String, mListCategories: List<CategoryModel>) {
            categoryName.text = name
            categoryDescription.text = description
            itemView.setOnClickListener {
                listener.onMovieClicked(itemView, mListCategories[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TournamentHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_item, parent, false)
        return TournamentHolder(view, listener)
    }

    override fun getItemCount(): Int = mListCategories.size

    fun setList(list: List<CategoryModel>) {
        mListCategories = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TournamentHolder, position: Int) {
        holder.bind(
            mListCategories[position].name,
            mListCategories[position].description,
            mListCategories
        )
    }
}
