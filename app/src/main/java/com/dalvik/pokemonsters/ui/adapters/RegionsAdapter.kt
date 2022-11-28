package com.dalvik.pokemonsters.ui.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.databinding.ItemListRegionsBinding
import com.dalvik.pokemonsters.network.model.regions.Region
import com.dalvik.pokemonsters.utils.PARAM_ITEM_REGION
import com.dalvik.pokemonsters.utils.PARAM_ITEM_REGION_NAME
import com.dalvik.pokemonsters.utils.PARAM_ITEM_REGION_SERIE_URL
import com.dalvik.pokemonsters.utils.PARAM_ITEM_REGION_TOTAL

class RegionsAdapter(private var regionslist: List<Region>) :
    RecyclerView.Adapter<RegionsAdapter.RegionViewHolder>() {


    class RegionViewHolder(private val itemListRegionsBinding: ItemListRegionsBinding) :
        RecyclerView.ViewHolder(itemListRegionsBinding.root) {
        fun bindCharacter(region: Region) {
            itemListRegionsBinding.region = region
            itemListRegionsBinding.executePendingBindings()
            itemListRegionsBinding.cardContainer.setOnClickListener {
                it.findNavController().navigate(
                    R.id.action_regionFragment_to_regionPokemonFragment,
                    Bundle().apply {
                        putInt(
                            PARAM_ITEM_REGION,
                            region.id
                        )
                        putString(
                            PARAM_ITEM_REGION_NAME,
                            region.name
                        )
                        putString(
                            PARAM_ITEM_REGION_TOTAL,
                            region.totalPokemon
                        )
                        putString(
                            PARAM_ITEM_REGION_SERIE_URL,
                            region.serieUrl
                        )
                    }
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegionViewHolder {
        val layoutInflater = ItemListRegionsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RegionViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: RegionViewHolder, position: Int) {
        holder.bindCharacter(regionslist[position])
    }

    override fun getItemCount(): Int {
        return regionslist.size
    }


}