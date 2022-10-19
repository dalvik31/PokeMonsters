package com.dalvik.pokemonsters.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.navigation.findNavController
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.databinding.FragmentDetailNewsBinding
import com.dalvik.pokemonsters.network.model.news.News
import com.dalvik.pokemonsters.ui.base.BaseFragment
import com.dalvik.pokemonsters.utils.PARAM_ITEM_NEWS
import com.dalvik.pokemonsters.utils.PARAM_URL_NEWS
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailNewsFragment : BaseFragment<FragmentDetailNewsBinding, NewsViewModel, NewsViewModel>(
    NewsViewModel::class.java,
    NewsViewModel::class.java
) {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailNewsBinding
        get() = FragmentDetailNewsBinding::inflate


    override fun bindViewModel(binding: FragmentDetailNewsBinding, viewModel: NewsViewModel) {

    }

    override fun setupUiBehavior() {
        searchArguments()

        val youTubePlayerView = binding.youtubePlayerView
        lifecycle.addObserver(youTubePlayerView)

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                viewModel.itemVideo.value?.let {
                    youTubePlayer.loadVideo(viewModel.itemVideo.value!!, 0f)
                }
            }
        })


        binding.fabOpenWeb.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_detailNewsFragment_to_webViewFragment,
                Bundle().apply {
                    putString(
                        PARAM_URL_NEWS,
                        viewModel.urlNews.value
                    )
                }
            )
        }

    }

    override fun subscribeToEvents() {

    }

    private fun searchArguments() {
        arguments?.getParcelable<News>(PARAM_ITEM_NEWS)?.let {
            binding.news = it
            viewModel.itemVideo.postValue(it.video_url)
            binding.showFabWebView = !it.page_url.isNullOrEmpty()
            viewModel.urlNews.postValue(it.page_url)
        }
    }


}