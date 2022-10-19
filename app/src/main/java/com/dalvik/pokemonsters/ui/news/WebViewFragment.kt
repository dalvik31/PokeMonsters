package com.dalvik.pokemonsters.ui.news

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.dalvik.pokemonsters.databinding.FragmentHomeBinding
import com.dalvik.pokemonsters.databinding.FragmentWebViewBinding
import com.dalvik.pokemonsters.ui.base.BaseFragment
import com.dalvik.pokemonsters.utils.PARAM_ITEM_POKEMON_ID
import com.dalvik.pokemonsters.utils.PARAM_URL_NEWS
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WebViewFragment : BaseFragment<FragmentWebViewBinding, NewsViewModel, NewsViewModel>(
    NewsViewModel::class.java,
    NewsViewModel::class.java
) {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentWebViewBinding
        get() = FragmentWebViewBinding::inflate

    override fun bindViewModel(binding: FragmentWebViewBinding, viewModel: NewsViewModel) {

    }

    override fun setupUiBehavior() {
        searchArguments()
    }

    override fun subscribeToEvents() {

    }

    private fun searchArguments() {
        arguments?.let { Bundle ->
            Bundle.getString(PARAM_URL_NEWS)?.let {
                loadUrl(it)
            }

        }
    }

    private fun loadUrl(url:String){

        binding.webviewPageUrl.loadUrl(url)
        binding.webviewPageUrl.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                val url = request?.url.toString()
                view?.loadUrl(url)
                return super.shouldOverrideUrlLoading(view, request)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                binding.lottieProgress.visibility = View.VISIBLE
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                binding.lottieProgress.visibility = View.GONE
                super.onPageFinished(view, url)
            }

            override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
                super.onReceivedError(view, request, error)
            }
        }
    }
}