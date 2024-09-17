package com.klt.androidkotlinexamples.supeheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.klt.androidkotlinexamples.databinding.ItemSuperheroBinding

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superHeroItemResponse: SuperHeroItemResponse){

        binding.tvSuperheroName.text = superHeroItemResponse.name

    }

}