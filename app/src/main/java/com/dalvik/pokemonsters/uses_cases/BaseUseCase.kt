package com.dalvik.pokemonsters.uses_cases

import com.dalvik.pokemonsters.ui.BaseViewModel
import com.dalvik.pokemonsters.utils.CustomLoader

abstract class BaseUseCaseWithParams<T, R : Any?> {
    abstract suspend operator fun invoke(
        viewModel: BaseViewModel,
        params: T,
        loader: CustomLoader.Type = CustomLoader.Type.FULL
    ): R
}

abstract class BaseUseCase<T : Any?> {
    abstract suspend operator fun invoke(
        viewModel: BaseViewModel,
        loader: CustomLoader.Type = CustomLoader.Type.FULL
    ): T
}

