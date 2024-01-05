package com.example.domain.usecase

import com.example.domain.repo.MealsRepo
import javax.inject.Inject

class GetMeals (private var mealsRepo: MealsRepo) {

 suspend  operator fun invoke()=mealsRepo.getMealsFromRemote()
 //suspend  operator fun invoke()=mealsRepo.

}