package com.dalvik.pokemonsters.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dalvik.pokemonsters.databinding.ItemListRegionsBinding
import com.dalvik.pokemonsters.network.model.regions.Region

class RegionsAdapter(private var regionslist: List<Region>) :
    RecyclerView.Adapter<RegionsAdapter.RegionViewHolder>() {


    class RegionViewHolder(private val itemListRegionsBinding: ItemListRegionsBinding) :
        RecyclerView.ViewHolder(itemListRegionsBinding.root) {
        fun bindCharacter(region: Region) {
            itemListRegionsBinding.region = region
            itemListRegionsBinding.executePendingBindings()
            itemListRegionsBinding.root.setOnClickListener {
                /*it.findNavController().navigate(
                    R.id.action_homeFragment_to_detailNewsFragment,
                    Bundle().apply {
                        putParcelable(
                            PARAM_ITEM_NEWS,
                            news
                        )
                    }
                )*/
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