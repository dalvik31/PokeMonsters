package com.dalvik.pokemonsters.network.services

import com.dalvik.pokemonsters.network.model.news.News
import com.dalvik.pokemonsters.network.model.pokemon.Pokemon
import com.dalvik.superhero.model.base.ResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeServices {

    @GET("PokeMonsters/main/data/news")
    suspend fun getNews(): Response<ResponseModel<News>>

    @GET("PokeMonsters/main/data/regions/{id}")
    suspend fun getPokemonRegion(@Path(value = "id") id: Int): Response<ResponseModel<Pokemon>>
}