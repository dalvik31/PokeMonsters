package com.dalvik.pokemonsters.uses_cases

import com.dalvik.pokemonsters.network.ResultData
import com.dalvik.pokemonsters.network.model.news.News
import com.dalvik.pokemonsters.network.model.pokemon.DetailPokemon
import com.dalvik.pokemonsters.network.repository.Repository
import com.dalvik.pokemonsters.ui.base.BaseViewModel
import com.dalvik.pokemonsters.utils.CustomLoader
import javax.inject.Inject


class GetPokemonByIdUseCase @Inject constructor(private val repository: Repository) :
    BaseUseCaseWithParams<String,ResultData<DetailPokemon>>() {
    override suspend fun invoke(
        viewModel: BaseViewModel,
        params: String,
        loader: CustomLoader.Type
    ): ResultData<DetailPokemon> {
        return viewModel.execute(
            loader,
            suspend { repository.getRemotePokemonById(params) })
    }



}