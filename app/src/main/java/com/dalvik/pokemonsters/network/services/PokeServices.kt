package com.dalvik.pokemonsters.network.services

import com.dalvik.pokemonsters.network.model.news.News
import com.dalvik.superhero.model.base.ResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface PokeServices {

    @GET("Pokemon/master/news")
    suspend fun getNews(): Response<ResponseModel<News>>

}