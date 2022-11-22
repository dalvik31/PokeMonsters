package com.dalvik.pokemonsters.ui.news

import android.content.Context
import android.content.pm.ActivityInfo
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.dalvik.pokemonsters.databinding.FragmentWebViewBinding
import com.dalvik.pokemonsters.ui.base.BaseFragment
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

    override fun onDetach() {
        super.onDetach()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR;
    }

    override fun onDestroy() {
        super.onDestroy()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
    }

    private fun loadUrl(url:String){

        binding.webviewPageUrl.loadUrl(url)
        binding.webviewPageUrl.settings.javaScriptEnabled = true
        binding.webviewPageUrl.settings.domStorageEnabled = true
        binding.webviewPageUrl.settings.mediaPlaybackRequiresUserGesture = false
        binding.webviewPageUrl.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                view?.loadUrl( request?.url.toString())
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