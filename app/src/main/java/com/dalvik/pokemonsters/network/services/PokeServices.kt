package com.dalvik.pokemonsters.network.services

import com.dalvik.pokemonsters.network.model.ResponseModel
import com.dalvik.pokemonsters.network.model.config.Config
import com.dalvik.pokemonsters.network.model.news.News
import com.dalvik.pokemonsters.network.model.pokemon.DetailPokemon
import com.dalvik.pokemonsters.network.model.pokemon.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeServices {

    @GET("PokeMonsters/main/data/news")
    suspend fun getNews(): Response<ResponseModel<News>>

    @GET("PokeMonsters/main/data/regions/{id}")
    suspend fun getPokemonRegion(@Path(value = "id") id: Int): Response<ResponseModel<Pokemon>>

    @GET("PokeMonsters/main/data/pokemon/{id}")
    suspend fun getPokemonById(@Path(value = "id") id: String): Response<ResponseModel<DetailPokemon>>

    @GET("PokeMonsters/main/data/config")
    suspend fun getConfig(): Response<ResponseModel<Config>>
}