package com.dalvik.pokemonsters.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.databinding.ItemListPokemonBinding
import com.dalvik.pokemonsters.databinding.ItemListRegionsBinding
import com.dalvik.pokemonsters.network.model.pokemon.Pokemon
import com.dalvik.pokemonsters.network.model.regions.Region

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
                    /*Bundle().apply {
                        putParcelable(
                            PARAM_ITEM_NEWS,
                            news
                        )
                    }*/
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