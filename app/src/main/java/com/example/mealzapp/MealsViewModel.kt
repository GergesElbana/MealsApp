package com.example.mealzapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.CategorResponce
import com.example.domain.usecase.GetMeals
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel@Inject constructor(
    private val getMealsUseCase:GetMeals
    //private val getMealsFromCache: GetMealsFromCache

) :ViewModel(){
    private val _categories:MutableStateFlow<CategorResponce?> = MutableStateFlow(null)
    val categories:StateFlow<CategorResponce?> = _categories
        fun getMeals(){
            viewModelScope.launch {
                try {
                  _categories.value= getMealsUseCase()
                }catch (e:Exception){
                    Log.d("erorViewmodel",e.message.toString())
                }
            }
        }
}