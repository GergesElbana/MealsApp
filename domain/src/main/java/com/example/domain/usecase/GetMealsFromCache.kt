package com.example.domain.usecase

import com.example.domain.entity.CategorResponce

interface GetMealsFromCache {
    suspend operator fun invoke():CategorResponce
}