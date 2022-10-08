package com.dalvik.pokemonsters

import android.R
import android.support.annotation.NonNull
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentContainerView
import com.dalvik.pokemonsters.databinding.FragmentDetailNewsBinding
import com.dalvik.pokemonsters.network.model.news.News
import com.dalvik.pokemonsters.ui.BaseFragment
import com.dalvik.pokemonsters.utils.PARAM_ITEM_NEWS
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

    }

    override fun subscribeToEvents() {

    }

    private fun searchArguments() {
        arguments?.getParcelable<News>(PARAM_ITEM_NEWS)?.let {
            binding.news = it
            viewModel.itemVideo.postValue(it.video_url)
        }
    }


}