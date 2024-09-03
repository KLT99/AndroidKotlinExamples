package com.klt.androidkotlinexamples.todoapp

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.klt.androidkotlinexamples.R

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvTask:TextView = view.findViewById(R.id.tvTask)
    private val cbTask:CheckBox = view.findViewById(R.id.cbTasks)

    fun render(task: Task){

        tvTask.text = task.name

    }

}