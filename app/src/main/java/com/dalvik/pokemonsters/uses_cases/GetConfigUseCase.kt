package com.dalvik.pokemonsters.uses_cases

import com.dalvik.pokemonsters.network.ResultData
import com.dalvik.pokemonsters.network.model.config.Config
import com.dalvik.pokemonsters.network.repository.Repository
import com.dalvik.pokemonsters.ui.base.BaseViewModel
import com.dalvik.pokemonsters.utils.CustomLoader
import javax.inject.Inject


class GetConfigUseCase @Inject constructor(private val repository: Repository) :
    BaseUseCase<ResultData<Config>>() {
    override suspend fun invoke(
        viewModel: BaseViewModel,
        loader: CustomLoader.Type
    ): ResultData<Config> {
        return viewModel.execute(
            loader,
            suspend { repository.getRemoteConfig() })
    }


}