package com.dalvik.pokemonsters.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dalvik.pokemonsters.network.model.news.News
import com.dalvik.pokemonsters.ui.NewsAdapter
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

    }

}
