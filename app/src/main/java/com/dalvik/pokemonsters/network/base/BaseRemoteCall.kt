package com.dalvik.pokemonsters.network.base

import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.network.ResultData
import com.dalvik.pokemonsters.network.data
import com.dalvik.pokemonsters.network.dataList
import com.dalvik.pokemonsters.utils.App
import com.dalvik.superhero.model.base.ResponseModel
import retrofit2.Response

abstract class BaseRemoteCall {

    /**
     * Wrap a suspending API in try/catch. In case an exception is thrown, a [ResultData.Error] is
     * created based on the [errorMessage].
     */
    private suspend fun <T : Any> safeApiCallBody(
        errorMessage: String,
        apiCall: suspend () -> Response<T>,
    ): ResultData<T> {
        return try {
            val response = apiCall()
            if (response.isSuccessful)
                ResultData.Success(response.body()!!)
            else {
                val responseErrorMessage = App.instance.getString(R.string.general_error,)

                ResultData.Error(
                    code = R.string.general_error,
                    message = responseErrorMessage
                )
            }
        } catch (e: Exception) {
            ResultData.Error(R.string.general_error, e.message ?: errorMessage)
        }
    }

    suspend fun <T : Any> safeApiCallObject(
        errorMessage: String,
        apiCall: suspend () -> Response<ResponseModel<T>>
    ): ResultData<T> {
        val response = safeApiCallBody(errorMessage, apiCall)

        return try {
            when (response) {
                is ResultData.Success -> response.data()
                is ResultData.Error -> ResultData.Error(
                    message = response.message,
                    code = response.code
                )
            }
        } catch (e: Exception) {
            ResultData.Error(R.string.general_error, e.message ?: errorMessage)
        }
    }

    suspend fun <T : Any> safeApiCallList(
        errorMessage: String,
        apiCall: suspend () -> Response<ResponseModel<T>>
    ): ResultData<ArrayList<T>> {
        val response = safeApiCallBody(errorMessage, apiCall)

        return try {
            when (response) {
                is ResultData.Success -> response.dataList()
                is ResultData.Error -> ResultData.Error(
                    message = response.message,
                    code = response.code
                )
            }
        } catch (e: Exception) {
            ResultData.Error(R.string.general_error, e.message ?: errorMessage)
        }
    }
}