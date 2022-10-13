package com.dalvik.pokemonsters.network.model

class ResponseModel<T>(
    val code: Int,
    val data: ResultModel<T>
) {
    fun getValue(): ResultModel<T> {
        return data
    }
}