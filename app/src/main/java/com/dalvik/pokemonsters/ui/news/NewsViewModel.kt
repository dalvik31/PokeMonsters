package com.dalvik.pokemonsters.ui.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.network.ResultData
import com.dalvik.pokemonsters.network.model.news.News
import com.dalvik.pokemonsters.ui.base.BaseViewModel
import com.dalvik.pokemonsters.uses_cases.GetConfigUseCase
import com.dalvik.pokemonsters.uses_cases.GetNewsUseCase
import com.dalvik.pokemonsters.utils.App
import com.dalvik.pokemonsters.utils.CustomLoader
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsUseCase: GetNewsUseCase,
    private val getConfigUseCase: GetConfigUseCase
) : BaseViewModel(App.instance) {

    var itemList = MutableLiveData<ArrayList<News>>(arrayListOf())
    var itemVideo = MutableLiveData("")
    var urlNews = MutableLiveData("")
    var showAllTabs = MutableLiveData(false)
    var msgLoadInformation = MutableLiveData(App.instance.getString(R.string.msg_load_section))

    init {
        getConfig()
    }

    private fun getNews() {
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
                    itemList.postValue(ArrayList(resultNews.model.filter {
                        it.start_date != null
                    }.sortedByDescending { it.start_date }))
                    urlNews
                }
            }
        }
    }

    fun getConfig() {
        viewModelScope.launch {
            when (val resultConfig = getConfigUseCase(
                loader = CustomLoader.Type.SOFT,
                viewModel = this@NewsViewModel
            )) {
                is ResultData.Error -> {
                    //Nothing here this error is management by BaseViewModel class
                    //The same error is here resultCharacter.message to send viewmodel inside xml
                }

                is ResultData.Success -> {
                    if (resultConfig.model.addAllTabs == true) {
                        getNews()
                        showAllTabs.postValue(true)
                    } else {
                        msgLoadInformation.postValue(App.instance.getString(R.string.msg_section_maintenance))
                    }
                }
            }

        }
    }
}