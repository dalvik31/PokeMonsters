package com.dalvik.pokemonsters.ui.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.databinding.ItemTypeBinding
import com.dalvik.pokemonsters.network.model.type.TypePokemon
import com.dalvik.pokemonsters.utils.PARAM_ITEM_POKEMON_NAME
import com.dalvik.pokemonsters.utils.PARAM_ITEM_POKEMON_SRC

class TypePokemonAdapter(private var typeList: MutableList<TypePokemon>) :
    RecyclerView.Adapter<TypePokemonAdapter.TextViewHolder>() {


    class TextViewHolder(private val itemTypeBinding: ItemTypeBinding) :
        RecyclerView.ViewHolder(itemTypeBinding.root) {
        fun bindCharacter(type: TypePokemon) {
            itemTypeBinding.tvType.setText(type.name)
            itemTypeBinding.imgType.setImageResource(type.image)
            if(type.isClickable){
                itemTypeBinding.root.setOnClickListener {
                    it.findNavController().navigate(
                        R.id.action_tableTypeFragment_to_typeDetailsFragment,
                        Bundle().apply {
                            putInt(
                                PARAM_ITEM_POKEMON_NAME,
                                type.name
                            )
                            putInt(
                                PARAM_ITEM_POKEMON_SRC,
                                type.image
                            )
                        }
                    )
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val layoutInflater = ItemTypeBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TextViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.bindCharacter(typeList[position])
    }

    override fun getItemCount(): Int {
        return typeList.size
    }


}