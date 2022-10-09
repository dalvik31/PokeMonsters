package com.dalvik.pokemonsters.network.interfaces

import com.dalvik.pokemonsters.network.ResultData
import com.dalvik.pokemonsters.network.model.news.News
import com.dalvik.pokemonsters.network.model.pokemon.Pokemon

interface PokemonDataSourceInterface {
    suspend fun getRemoteNews(): ResultData<ArrayList<News>>

    suspend fun getRemotePokemonRegions(regionId: Int): ResultData<ArrayList<Pokemon>>
}