package com.dalvik.pokemonsters.network.interfaces

import com.dalvik.pokemonsters.network.ResultData
import com.dalvik.pokemonsters.network.model.news.News

interface PokemonDataSourceInterface {
    //CHARACTERS BASIC
    suspend fun getRemoteNews(): ResultData<ArrayList<News>>
}