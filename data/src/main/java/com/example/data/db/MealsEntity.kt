package com.example.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity("Meals_table")
data class MealsEntity (
    @PrimaryKey
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)