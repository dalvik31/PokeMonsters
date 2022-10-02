package com.dalvik.pokemonsters.uses_cases

import com.dalvik.pokemonsters.network.ResultData
import com.dalvik.pokemonsters.network.model.news.News
import com.dalvik.pokemonsters.network.repository.Repository
import com.dalvik.pokemonsters.ui.BaseViewModel
import com.dalvik.pokemonsters.utils.CustomLoader
import javax.inject.Inject


class GetNewsUseCase @Inject constructor(private val repository: Repository) :
    BaseUseCase<ResultData<ArrayList<News>>>() {
    override suspend fun invoke(
        viewModel: BaseViewModel,
        loader: CustomLoader.Type
    ): ResultData<ArrayList<News>> {
        return viewModel.execute(
            loader,
            suspend { repository.getRemoteNews() })
    }


}