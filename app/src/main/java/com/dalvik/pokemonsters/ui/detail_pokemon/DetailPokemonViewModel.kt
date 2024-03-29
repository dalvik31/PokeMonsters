package com.dalvik.pokemonsters.ui.detail_pokemon

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dalvik.pokemonsters.network.ResultData
import com.dalvik.pokemonsters.network.model.pokemon.DetailPokemon
import com.dalvik.pokemonsters.ui.base.BaseViewModel
import com.dalvik.pokemonsters.uses_cases.GetPokemonByIdUseCase
import com.dalvik.pokemonsters.utils.App
import com.dalvik.pokemonsters.utils.CustomLoader
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailPokemonViewModel @Inject constructor(
    private val pokemonByIdUseCase: GetPokemonByIdUseCase
) : BaseViewModel(App.instance) {

    var pokemon = MutableLiveData<DetailPokemon>()
    var pokemonId = MutableLiveData<String>()
    var pokemonType = MutableLiveData<Int>()
    var pokemonSrc = MutableLiveData<Int>()

    fun getPokemon(pokemonId: String) {
        this.pokemonId.value = pokemonId
        getPokemonById()
    }


    private fun getPokemonById() {
        viewModelScope.launch {
            pokemonId.value?.let {
                when (val resultPokemonDetail = pokemonByIdUseCase(
                    loader = CustomLoader.Type.SOFT,
                    params = it,
                    viewModel = this@DetailPokemonViewModel
                )) {
                    is ResultData.Error -> {
                        //Nothing here this error is management by BaseViewModel class
                        //The same error is here resultCharacter.message to send viewmodel inside xml
                    }
                    is ResultData.Success -> {
                        val pokemonDetail = resultPokemonDetail.model
                        pokemonSrc.postValue(pokemonDetail.getTypeSrc())
                        pokemonType.postValue(pokemonDetail.getTypeName())
                        pokemon.postValue(pokemonDetail)
                    }
                }
            }
        }
    }
}