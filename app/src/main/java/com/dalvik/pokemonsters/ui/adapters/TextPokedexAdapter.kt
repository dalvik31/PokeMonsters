package com.dalvik.pokemonsters.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dalvik.pokemonsters.databinding.ItemImagesPokemonBinding
import com.dalvik.pokemonsters.databinding.ItemPokedexTextPokemonBinding
import com.dalvik.pokemonsters.network.model.text_pokedex.TextPokedex

class TextPokedexAdapter(private var textList: MutableList<TextPokedex>) :
    RecyclerView.Adapter<TextPokedexAdapter.TextViewHolder>() {


    class TextViewHolder(private val itemPokedexTextPokemonBinding: ItemPokedexTextPokemonBinding) :
        RecyclerView.ViewHolder(itemPokedexTextPokemonBinding.root) {
        fun bindCharacter(text: TextPokedex) {
            itemPokedexTextPokemonBinding.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val layoutInflater = ItemPokedexTextPokemonBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TextViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.bindCharacter(textList[position])
    }

    override fun getItemCount(): Int {
        return textList.size
    }


}