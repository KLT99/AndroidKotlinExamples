package com.klt.androidkotlinexamples.todoapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.klt.androidkotlinexamples.R

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)

    fun render(taskCategory: TaskCategory){

    }

}