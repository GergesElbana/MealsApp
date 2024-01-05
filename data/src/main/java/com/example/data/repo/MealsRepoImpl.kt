package com.example.data.repo

import android.annotation.SuppressLint
import com.example.data.db.MealsDao
import com.example.data.db.MealsEntity
import com.example.data.remote.ApiService
import com.example.domain.entity.CategorResponce
import com.example.domain.repo.MealsRepo

class MealsRepoImpl (
    private val apiService: ApiService,
    private val mealsDao: MealsDao
    ):MealsRepo {
   // override suspend fun getMealsFromRemote(): CategorResponce =apiService.getMeals()
    @SuppressLint("SuspiciousIndentation")
    override suspend fun getMealsFromRemote(): CategorResponce{
        val responce=apiService.getMeals()
          mealsDao.insertCategories(responce.categories.map {
              category ->  MealsEntity(
              idCategory = category.idCategory,
              strCategory = category.strCategory,
              strCategoryDescription = category.strCategoryDescription,
              strCategoryThumb = category.strCategoryThumb
              )
          })
       return responce


    }
    // Additional method to get data from Room (for offline mode)
    suspend fun getMealsFromCache(): List<MealsEntity> {
        return mealsDao.getCategories()
    }
}