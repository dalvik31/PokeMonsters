package com.dalvik.pokemonsters

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import com.dalvik.pokemonsters.databinding.FragmentDetailNewsBinding
import com.dalvik.pokemonsters.databinding.FragmentHomeBinding
import com.dalvik.pokemonsters.network.model.news.News
import com.dalvik.pokemonsters.ui.BaseFragment
import com.dalvik.pokemonsters.ui.BaseViewModel
import com.dalvik.pokemonsters.utils.PARAM_ITEM_NEWS
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailNewsFragment: BaseFragment<FragmentDetailNewsBinding, NewsViewModel, NewsViewModel>(
    NewsViewModel::class.java,
    NewsViewModel::class.java
) {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailNewsBinding
        get() = FragmentDetailNewsBinding::inflate

    override fun bindViewModel(binding: FragmentDetailNewsBinding, viewModel: NewsViewModel) {

    }

    override fun setupUiBehavior() {
        searchArguments()
    }

    override fun subscribeToEvents() {

    }

    private fun searchArguments(){
        arguments?.getParcelable<News>(PARAM_ITEM_NEWS)?.let {
            binding.news = it
        }
    }

}