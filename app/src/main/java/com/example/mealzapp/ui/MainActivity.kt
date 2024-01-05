package com.example.mealzapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mealzapp.MealsViewModel
import com.example.mealzapp.R

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
   private val mealsVeiwModel :MealsViewModel by  viewModels()
    lateinit var mealsAdpter:MealsAdapter
  private lateinit var  rv:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv=findViewById(R.id.MealsRecyclerView)
setupUI()


        mealsVeiwModel.getMeals()

        lifecycleScope.launch {
            mealsVeiwModel.categories.collect{
                val let = it?.categories?.let(mealsAdpter::addData)
                rv.adapter=mealsAdpter
            }
        }
    }
    private fun setupUI() {

        rv.layoutManager = LinearLayoutManager(this)
        mealsAdpter = MealsAdapter(arrayListOf())
        rv.addItemDecoration(
            DividerItemDecoration(
                rv.context,
                (rv.layoutManager as LinearLayoutManager).orientation
            )
        )
        rv.adapter = mealsAdpter
    }
}