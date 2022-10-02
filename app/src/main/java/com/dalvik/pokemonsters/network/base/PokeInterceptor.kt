package com.dalvik.pokemonsters.network.base

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response


object PokeInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return chain.proceed(request)
    }
}