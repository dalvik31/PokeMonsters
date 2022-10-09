package com.dalvik.pokemonsters.uses_cases

import com.dalvik.pokemonsters.network.ResultData
import com.dalvik.pokemonsters.network.model.pokemon.Pokemon
import com.dalvik.pokemonsters.network.repository.Repository
import com.dalvik.pokemonsters.ui.base.BaseViewModel
import com.dalvik.pokemonsters.utils.CustomLoader
import javax.inject.Inject


class GetPokemonRegionUseCase @Inject constructor(private val repository: Repository) :
    BaseUseCaseWithParams<Int, ResultData<ArrayList<Pokemon>>>() {
    override suspend fun invoke(
        viewModel: BaseViewModel,
        params: Int,
        loader: CustomLoader.Type
    ): ResultData<ArrayList<Pokemon>> {
        return viewModel.execute(
            loader,
            suspend { repository.getRemotePokemonRegions(params) })
    }


}