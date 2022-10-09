package com.dalvik.pokemonsters.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dalvik.pokemonsters.network.model.news.News
import com.dalvik.pokemonsters.network.model.pokemon.Pokemon
import com.dalvik.pokemonsters.network.model.regions.Region
import com.dalvik.pokemonsters.ui.adapters.NewsAdapter
import com.dalvik.pokemonsters.ui.adapters.RegionsAdapter
import com.dalvik.pokemonsters.ui.adapters.RegionsPokemonAdapter
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso


class BindingAdapters {

    companion object {

        @JvmStatic
        @BindingAdapter("android:imageUrl")
        fun setImageUrl(imageView: ImageView, url: String?) {
            try {
                imageView.alpha = 0f
                Picasso.get().load(url).noFade().into(imageView, object : Callback {
                    override fun onSuccess() {
                        imageView.animate().setDuration(300).alpha(1f).start()
                    }

                    override fun onError(e: Exception) {}
                })

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        @JvmStatic
        @BindingAdapter("app:listNews")
        fun setListNews(recyclerView: RecyclerView, cardsList: List<News>?) {
            if (cardsList != null && cardsList.isNotEmpty()) {
                val characterAdapter = NewsAdapter(cardsList)
                recyclerView.setHasFixedSize(true)
                recyclerView.adapter = characterAdapter
            }
        }

        @JvmStatic
        @BindingAdapter("app:listRegions")
        fun setListRegions(recyclerView: RecyclerView, regionsList: List<Region>?) {
            if (regionsList != null && regionsList.isNotEmpty()) {
                val characterAdapter = RegionsAdapter(regionsList)
                recyclerView.setHasFixedSize(true)
                recyclerView.adapter = characterAdapter
            }
        }

        @JvmStatic
        @BindingAdapter("app:listPokemon")
        fun setListPokemon(recyclerView: RecyclerView, pokemonsList: List<Pokemon>?) {
            if (pokemonsList != null && pokemonsList.isNotEmpty()) {
                val characterAdapter = RegionsPokemonAdapter(pokemonsList)
                recyclerView.setHasFixedSize(true)
                recyclerView.adapter = characterAdapter
            }
        }


        @JvmStatic
        @BindingAdapter("app:src")
        fun setCustomImage(view: ImageView, img: Int?) {
            img?.let {
                view.setImageResource(it)
            }

        }

    }

}
