package com.dalvik.pokemonsters.ui.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dalvik.pokemonsters.network.ResultData
import com.dalvik.pokemonsters.network.model.news.News
import com.dalvik.pokemonsters.ui.base.BaseViewModel
import com.dalvik.pokemonsters.uses_cases.GetNewsUseCase
import com.dalvik.pokemonsters.utils.App
import com.dalvik.pokemonsters.utils.CustomLoader
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsUseCase: GetNewsUseCase
) : BaseViewModel(App.instance) {

    var itemList = MutableLiveData<ArrayList<News>>(arrayListOf())
    var itemVideo = MutableLiveData("")
    var urlNews = MutableLiveData("")

    fun getNews() {
        viewModelScope.launch {
            when (val resultNews = newsUseCase(
                loader = CustomLoader.Type.SOFT,
                viewModel = this@NewsViewModel
            )) {
                is ResultData.Error -> {
                    //Nothing here this error is management by BaseViewModel class
                    //The same error is here resultCharacter.message to send viewmodel inside xml
                }
                is ResultData.Success -> {
                    itemList.postValue(ArrayList(resultNews.model.sortedByDescending { it.start_date?.toLong() }))
                    urlNews
                }
            }
        }
    }
}