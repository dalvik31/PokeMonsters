package com.dalvik.superhero.model.base

class ResponseModel<T>(
    val code: Int,
    val data: ResultModel<T>
) {
    fun getValue(): ResultModel<T> {
        return data
    }
}