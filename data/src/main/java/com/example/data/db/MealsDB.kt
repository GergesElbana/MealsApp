package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [MealsEntity::class], version = 1)
abstract class MealsDB :RoomDatabase() {
    abstract fun mealDao(): MealsDao
}