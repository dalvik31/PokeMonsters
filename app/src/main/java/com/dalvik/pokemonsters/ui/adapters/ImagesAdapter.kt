package com.dalvik.pokemonsters.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.databinding.ItemImagesPokemonBinding
import com.dalvik.pokemonsters.network.model.images.Images
import com.dalvik.pokemonsters.utils.getThumbnail
import com.dalvik.pokemonsters.utils.getThumbnailShiny

class ImagesAdapter(private var imagesList: ArrayList<Images>) :
    RecyclerView.Adapter<ImagesAdapter.ImageViewHolder>() {


    class ImageViewHolder(private val itemListImagesBinding: ItemImagesPokemonBinding) :
        RecyclerView.ViewHolder(itemListImagesBinding.root) {
        fun bindCharacter(image: Images, position: Int) {

            if (position == 0) {
                itemListImagesBinding.hideImage = false
                itemListImagesBinding.icShiny.visibility = View.VISIBLE
                itemListImagesBinding.normalImage = (image.thumbnail ?: "").getThumbnail()
                itemListImagesBinding.shinyImage = (image.thumbnailShiny ?: "").getThumbnailShiny()
                Glide.with(itemListImagesBinding.imageShiny.context)
                    .load(R.drawable.shiny9)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(itemListImagesBinding.imageShiny)
            } else {
                itemListImagesBinding.hideImage = true
                itemListImagesBinding.icShiny.visibility = View.GONE
                itemListImagesBinding.image = image.thumbnail ?: ""
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val layoutInflater = ItemImagesPokemonBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ImageViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindCharacter(imagesList[position], position)
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }


}