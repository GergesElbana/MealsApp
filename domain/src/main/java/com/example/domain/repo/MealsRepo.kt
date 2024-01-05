package com.example.domain.repo

import com.example.domain.entity.CategorResponce

interface MealsRepo  {
  suspend  fun getMealsFromRemote():CategorResponce
}