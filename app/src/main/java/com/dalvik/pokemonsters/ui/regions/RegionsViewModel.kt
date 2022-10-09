package com.dalvik.pokemonsters.ui.regions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.network.ResultData
import com.dalvik.pokemonsters.network.model.news.News
import com.dalvik.pokemonsters.network.model.regions.Region
import com.dalvik.pokemonsters.ui.base.BaseViewModel
import com.dalvik.pokemonsters.uses_cases.GetNewsUseCase
import com.dalvik.pokemonsters.utils.App
import com.dalvik.pokemonsters.utils.CustomLoader
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.collections.ArrayList

@HiltViewModel
class RegionsViewModel @Inject constructor(
    private val newsUseCase: GetNewsUseCase
) : BaseViewModel(App.instance) {

    var itemList = MutableLiveData<ArrayList<Region>>(arrayListOf())
    var itemVideo = MutableLiveData("")


    fun getRegions() {
      val list = ArrayList<Region>()
        val regionKanto = Region(
            1,
            "Kanto",
            "151",
            R.drawable.region_kanto,
            R.drawable.rock_medal,
            "Roca",
            R.drawable.watterfall_medal,
            "Cascada",
            R.drawable.thunder_medal,
            "Trueno",
            R.drawable.rainbow_medal,
            "Arcoiris",
            R.drawable.soul_medal,
            "Alma",
            R.drawable.swamp_medal,
            "Pantano",
            R.drawable.volcano_medal,
            "Volcan",
            R.drawable.earth_medal,
            "Tierra",)
        list.add(regionKanto)
        list.add(regionKanto)
        list.add(regionKanto)
        list.add(regionKanto)
        itemList.postValue(list)
    }
}