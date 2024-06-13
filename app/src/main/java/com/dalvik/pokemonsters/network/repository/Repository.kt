package com.dalvik.pokemonsters.network.repository

import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.network.ResultData
import com.dalvik.pokemonsters.network.base.BaseRemoteCall
import com.dalvik.pokemonsters.network.interfaces.PokemonDataSourceInterface
import com.dalvik.pokemonsters.network.model.config.Config
import com.dalvik.pokemonsters.network.model.news.News
import com.dalvik.pokemonsters.network.model.pokemon.DetailPokemon
import com.dalvik.pokemonsters.network.model.pokemon.Pokemon
import com.dalvik.pokemonsters.network.services.PokeServices
import com.dalvik.pokemonsters.utils.App
import javax.inject.Inject

class Repository @Inject constructor(
    private val pokeServices: PokeServices
) : BaseRemoteCall(), PokemonDataSourceInterface {
    override suspend fun getRemoteNews(): ResultData<ArrayList<News>> =
        safeApiCallList(App.instance.getString(R.string.error_download_news)) {
            pokeServices.getNews()
        }

    override suspend fun getRemotePokemonRegions(regionId: Int): ResultData<ArrayList<Pokemon>> =
        safeApiCallList(App.instance.getString(R.string.error_download_pokemon_region)) {
            pokeServices.getPokemonRegion(regionId)
        }

    override suspend fun getRemotePokemonById(pokemonId: String): ResultData<DetailPokemon> =
        safeApiCallObject(App.instance.getString(R.string.error_download_pokemon_detail)) {
            pokeServices.getPokemonById(pokemonId)
        }

    override suspend fun getRemoteConfig(): ResultData<Config> =
        safeApiCallObject(App.instance.getString(R.string.error_download_config)) {
            pokeServices.getConfig()
        }

}