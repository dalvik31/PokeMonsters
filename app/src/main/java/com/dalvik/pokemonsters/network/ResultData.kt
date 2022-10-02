package com.dalvik.pokemonsters.network

import androidx.annotation.StringRes
import com.dalvik.superhero.model.base.ResponseModel

sealed class ResultData<out T : Any> {
    data class Success<out T : Any>(val model: T) : ResultData<T>()
    data class Error(@StringRes val code: Int, val message: String) : ResultData<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$model]"
            is Error -> "Error[exception=$message]"
        }
    }
}

fun <T : Any> ResultData.Success<ResponseModel<T>>.data(): ResultData.Success<T> {
    return ResultData.Success(this.model.data.results.first())
}

fun <T : Any> ResultData.Success<ResponseModel<T>>.dataList(): ResultData.Success<ArrayList<T>> {
    return ResultData.Success(this.model.data.results)
}