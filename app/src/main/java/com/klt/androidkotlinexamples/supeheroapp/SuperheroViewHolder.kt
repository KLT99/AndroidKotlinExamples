package com.klt.androidkotlinexamples.supeheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.klt.androidkotlinexamples.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superHeroItemResponse: SuperHeroItemResponse, onItemSelected: (String) -> Unit) {

        binding.tvSuperheroName.text = superHeroItemResponse.name

        Picasso.get().load(superHeroItemResponse.superheroImage.url).into(binding.ivSuperhero)

        binding.root.setOnClickListener {
            onItemSelected(superHeroItemResponse.superheroId)
        }
    }

}