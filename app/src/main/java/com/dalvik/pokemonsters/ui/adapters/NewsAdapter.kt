package com.dalvik.pokemonsters.ui.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.databinding.ItemListNewsBinding
import com.dalvik.pokemonsters.network.model.news.News
import com.dalvik.pokemonsters.utils.PARAM_ITEM_NEWS

class NewsAdapter(private var newslist: List<News>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {


    class NewsViewHolder(private val itemListNewsBinding: ItemListNewsBinding) :
        RecyclerView.ViewHolder(itemListNewsBinding.root) {
        fun bindCharacter(news: News) {
            itemListNewsBinding.news = news
            itemListNewsBinding.executePendingBindings()
            itemListNewsBinding.root.setOnClickListener {
                it.findNavController().navigate(
                    R.id.action_homeFragment_to_detailNewsFragment,
                    Bundle().apply {
                        putParcelable(
                            PARAM_ITEM_NEWS,
                            news
                        )
                    }
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val layoutInflater = ItemListNewsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return NewsViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindCharacter(newslist[position])
    }

    override fun getItemCount(): Int {
        return newslist.size
    }


}