package com.dalvik.pokemonsters.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dalvik.pokemonsters.databinding.ItemListNewsBinding
import com.dalvik.pokemonsters.network.model.news.News

class NewsAdapter(private var newslist: List<News>) :
    RecyclerView.Adapter<NewsAdapter.CharacterViewHolder>() {


    class CharacterViewHolder(private val itemListNewsBinding: ItemListNewsBinding) :
        RecyclerView.ViewHolder(itemListNewsBinding.root) {
        fun bindCharacter(news: News) {
            itemListNewsBinding.news = news
            itemListNewsBinding.executePendingBindings()
            itemListNewsBinding.root.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = ItemListNewsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CharacterViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bindCharacter(newslist[position])
    }

    override fun getItemCount(): Int {
        return newslist.size
    }


}