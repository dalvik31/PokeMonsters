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
   val img_new_pokemon: String?

): Parcelable {

   fun getUrlImagePokemon():String{
      return "https://www.cpokemon.com/pokes/home/".plus(pokemon_num).plus(".png")
   }

   fun getUrlImageShinyPokemon():String{
      return "https://www.cpokemon.com/pokes/home/shiny/".plus(pokemon_num).plus(".png")
   }


   /* fun getShortDate():String{
       if(start_date == null) return ""
       val calendar = Calendar.getInstance(Locale.getDefault())
       calendar.timeInMillis = start_date.toLong()
       return android.text.format.DateFormat.format("E, dd MMM yyyy", calendar).toString()
    }*/

}