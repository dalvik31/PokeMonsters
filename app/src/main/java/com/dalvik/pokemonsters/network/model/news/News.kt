package com.dalvik.pokemonsters.network.model.news

import android.os.Parcelable
import com.dalvik.pokemonsters.utils.getImage
import com.dalvik.pokemonsters.utils.getThumbnailShiny
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val id: String?,
    val start_date: String?,
    val start_date_string: String?,
    val end_date: String?,
    val title: String?,
    val sub_title: String?,
    val thumbnail: String?,
    val image_url: String?,
    val description: String?,
    val video_url: String?,
    val page_url: String?,
    val pokemon_name: String?,
    val pokemon_num: String?,
    val pokemon_name_second: String?,
    val pokemon_num_second: String?,
    val pokemon_name_third: String?,
    val pokemon_num_third: String?,
    val img_new_pokemon: String?,
    val name_new_pokemon: String?

) : Parcelable {

    fun getUrlImagePokemon(): String {
        return (pokemon_num ?: "").getImage()
    }

    fun getUrlImageShinyPokemon(): String {
        return (pokemon_num ?: "").getThumbnailShiny()
    }

    fun getUrlSecondImagePokemon(): String {
        return (pokemon_num_second ?: "").getImage()
    }

    fun getUrlSecondImageShinyPokemon(): String {
        return (pokemon_num_second ?: "").getThumbnailShiny()
    }

    fun getUrlThirdImagePokemon(): String {
        return (pokemon_num_third ?: "").getImage()
    }

    fun getUrlThirdImageShinyPokemon(): String {
        return (pokemon_num_third ?: "").getThumbnailShiny()
    }

}