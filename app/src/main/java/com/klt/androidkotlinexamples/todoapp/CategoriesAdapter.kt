package com.klt.androidkotlinexamples.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.klt.androidkotlinexamples.R

//imprime las listas y las muestras
class CategoriesAdapter(private val categories: List<TaskCategory>):
    RecyclerView.Adapter<CategoriesViewHolder>() {

    //Crea la vista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):CategoriesViewHolder {
        //Crea un item_task_category por cada uno de los items (categorias)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false)
        return CategoriesViewHolder(view)
    }

    //pasa el item que debe mostrar de acuerdo a cada posicion
    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.render(categories[position])
    }

    override fun getItemCount() = categories.size

}