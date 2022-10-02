package com.dalvik.pokemonsters.network.model.news

import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.util.*

data class News(
   val id: String,
   val start_date: String?,
   val end_date: String,
   val title: String,
   val sub_title: String,
   val thumbnail: String,
   val image_url: String,
   val description: String,
   val video_url: String
){


   fun getShortDate():String{
      if(start_date == null) return ""
      val calendar = Calendar.getInstance(Locale.getDefault())
      calendar.timeInMillis = start_date.toLong()
      return android.text.format.DateFormat.format("E, dd MMM yyyy", calendar).toString()
   }

}