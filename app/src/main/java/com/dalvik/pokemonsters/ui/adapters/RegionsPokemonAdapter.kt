package com.dalvik.pokemonsters.ui.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.databinding.ItemListPokemonBinding
import com.dalvik.pokemonsters.network.model.pokemon.Pokemon
import com.dalvik.pokemonsters.utils.PARAM_ITEM_POKEMON_ID

class RegionsPokemonAdapter(private var pokemonlist: List<Pokemon>) :
    RecyclerView.Adapter<RegionsPokemonAdapter.PokemonViewHolder>() {


    class PokemonViewHolder(private val itemListPokemonBinding: ItemListPokemonBinding) :
        RecyclerView.ViewHolder(itemListPokemonBinding.root) {
        fun bindCharacter(pokemon: Pokemon) {
            itemListPokemonBinding.pokemon = pokemon
            itemListPokemonBinding.executePendingBindings()
            itemListPokemonBinding.root.setOnClickListener {
                it.findNavController().navigate(
                    R.id.action_regionPokemonFragment_to_detailPokemonFragment,
                    Bundle().apply {
                        putString(
                            PARAM_ITEM_POKEMON_ID,
                            pokemon.id
                        )
                    }
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val layoutInflater = ItemListPokemonBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PokemonViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bindCharacter(pokemonlist[position])
    }

    override fun getItemCount(): Int {
        return pokemonlist.size
    }


}