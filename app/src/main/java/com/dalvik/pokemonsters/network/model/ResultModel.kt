package com.dalvik.superhero.model.base

class ResultModel<T>(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: ArrayList<T>
)