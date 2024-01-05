package com.example.mealzapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.Category
import com.example.mealzapp.R

class MealsAdapter(private val MealsList: ArrayList<Category>) :
    RecyclerView.Adapter<MealsAdapter.MealsViewHolder>() {
    class MealsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val subtitleTextView: TextView = view.findViewById(R.id.subtitleTextView)
        val mealsPhoto: ImageView = view.findViewById(R.id.MealsImageView)


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MealsAdapter.MealsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.meals_item, parent, false)

        return MealsViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealsAdapter.MealsViewHolder, position: Int) {
        holder.titleTextView.text = MealsList[position].strCategory
        holder.subtitleTextView.text = MealsList[position].strCategoryDescription

    }

    override fun getItemCount(): Int {
        return MealsList.size
    }

    fun addData(list: List<Category>) {
        MealsList.addAll(list)
    }
}