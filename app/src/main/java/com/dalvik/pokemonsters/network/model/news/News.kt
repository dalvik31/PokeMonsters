package com.dalvik.pokemonsters.network.model.news

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.util.*

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

): Parcelable {

   fun getUrlImagePokemon():String{
      return "https://www.cpokemon.com/pokes/home/".plus(pokemon_num).plus(".png")
   }

   fun getUrlImageShinyPokemon():String{
      return "https://www.cpokemon.com/pokes/home/shiny/".plus(pokemon_num).plus(".png")
   }

   fun getUrlSecondImagePokemon():String{
      return "https://www.cpokemon.com/pokes/home/".plus(pokemon_num_second).plus(".png")
   }

   fun getUrlSecondImageShinyPokemon():String{
      return "https://www.cpokemon.com/pokes/home/shiny/".plus(pokemon_num_second).plus(".png")
   }

   fun getUrlThirdImagePokemon():String{
      return "https://www.cpokemon.com/pokes/home/".plus(pokemon_num_third).plus(".png")
   }

   fun getUrlThirdImageShinyPokemon():String{
      return "https://www.cpokemon.com/pokes/home/shiny/".plus(pokemon_num_third).plus(".png")
   }

}