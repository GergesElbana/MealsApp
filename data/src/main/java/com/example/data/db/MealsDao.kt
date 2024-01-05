package com.example.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MealsDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(categories: List<MealsEntity>)

    @Query("SELECT * FROM meals_table")
    suspend fun getCategories(): List<MealsEntity>


}