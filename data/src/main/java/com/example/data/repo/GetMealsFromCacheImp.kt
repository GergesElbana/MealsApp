package com.example.data.repo

import com.example.domain.entity.CategorResponce
import com.example.domain.repo.MealsRepo
import com.example.domain.usecase.GetMealsFromCache

class GetMealsFromCacheImp (private val mealsRepo: MealsRepo) : GetMealsFromCache {
    override suspend fun invoke(): CategorResponce? {
        // Use the repository method to fetch meals from the local cache (Room)
        return mealsRepo.getMealsFromCache()
    }
}