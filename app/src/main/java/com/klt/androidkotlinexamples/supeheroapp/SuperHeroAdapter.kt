package com.klt.androidkotlinexamples.supeheroapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.klt.androidkotlinexamples.R

class SuperHeroAdapter(
    var superHeroList: List<SuperHeroItemResponse> = emptyList(),
    private val onItemSelected: (String) -> Unit
) :
    RecyclerView.Adapter<SuperheroViewHolder>() {

    fun updateList(list: List<SuperHeroItemResponse>) {

        superHeroList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {

        return SuperheroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        )
    }

    override fun getItemCount() = superHeroList.size


    override fun onBindViewHolder(viewHolder: SuperheroViewHolder, position: Int) {

        viewHolder.bind(superHeroList[position], onItemSelected)
    }
}