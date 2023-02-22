package com.dalvik.pokemonsters.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.Nullable
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.network.model.images.Images
import com.dalvik.pokemonsters.network.model.news.News
import com.dalvik.pokemonsters.network.model.pokemon.Pokemon
import com.dalvik.pokemonsters.network.model.regions.Region
import com.dalvik.pokemonsters.network.model.text_pokedex.TextPokedex
import com.dalvik.pokemonsters.network.model.type.TypePokemon
import com.dalvik.pokemonsters.ui.adapters.*


class BindingAdapters {

    companion object {

        @JvmStatic
        @BindingAdapter("android:imageUrl")
        fun setImageUrl(imageView: ImageView, url: String?) {
            try {
                url?.let {
                    imageView.alpha = 0f
                    Glide.with(imageView.context)
                        .load(url)
                        .listener(object : RequestListener<Drawable?> {
                            override fun onLoadFailed(
                                @Nullable e: GlideException?,
                                model: Any,
                                target: Target<Drawable?>,
                                isFirstResource: Boolean
                            ): Boolean {
                                return false
                            }

                            override fun onResourceReady(
                                resource: Drawable?,
                                model: Any,
                                target: Target<Drawable?>,
                                dataSource: DataSource,
                                isFirstResource: Boolean
                            ): Boolean {
                                imageView.animate().setDuration(300).alpha(1f).start()
                                return false
                            }
                        })
                        .into(imageView)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        @JvmStatic
        @BindingAdapter("android:imageSrc")
        fun setImageSrc(imageView: ImageView, @DrawableRes drawableSrc: Int?) {
            imageView.setImageResource(
                drawableSrc ?: R.drawable.ic_normal
            )
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
        @BindingAdapter("app:listImages")
        fun setListImagePokemon(viewPager: ViewPager2, imagesList: ArrayList<Images>?) {
            if (imagesList != null && imagesList.isNotEmpty()) {
                val characterAdapter = ImagesAdapter(imagesList)
                viewPager.offscreenPageLimit = 1
                viewPager.adapter = characterAdapter
                viewPager.setPageTransformer { page, position ->
                    page.translationX = -40 * position
                    page.scaleY = 1 - (0.40f * kotlin.math.abs(position))
                }
            }
        }


        @JvmStatic
        @BindingAdapter("app:listText")
        fun setListTextPokedexPokemon(viewPager: ViewPager2, textList: MutableList<TextPokedex>?) {
            if (textList != null && textList.isNotEmpty()) {
                val textAdapter = TextPokedexAdapter(textList)
                viewPager.offscreenPageLimit = 1
                viewPager.adapter = textAdapter
                if(textList.size > 1){
                    viewPager.setPageTransformer { page, position ->
                        page.translationX = -80 * position
                        page.scaleY = 1 - (0.40f * kotlin.math.abs(position))
                    }
                }
            }
        }


        @JvmStatic
        @BindingAdapter("app:listTypesPokemon")
        fun setListTypesPokemon(recyclerView: RecyclerView, textList: MutableList<TypePokemon>?) {
            if (textList != null && textList.isNotEmpty()) {
                val textAdapter = TypePokemonAdapter(textList)
                recyclerView.adapter = textAdapter
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
