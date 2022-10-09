package com.dalvik.pokemonsters.ui.base

import androidx.annotation.DrawableRes
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.dalvik.pokemonsters.R
import com.dalvik.pokemonsters.network.ResultData
import com.dalvik.pokemonsters.utils.App
import com.dalvik.pokemonsters.utils.CustomLoader
import com.dalvik.pokemonsters.utils.SnackAlertView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


abstract class BaseViewModel(private val application: App) : AndroidViewModel(application) {

    /**
     * loading to notify service block main thread
     */
    val loading: MutableLiveData<CustomLoader.LoaderConfig> = MutableLiveData()

    /**
     * loading to notify service block main thread
     */
    val isLoading = ObservableBoolean()

    /**
     * showCustomAlert  show message to user success or fail
     */
    val showCustomAlert: MutableLiveData<SnackAlertView.Data> = MutableLiveData()


    /**
     * Coroutine to execute a block in a new Thread
     * @param loader: CustomLoader config indicating if show full, soft or none
     * @param service: Block to execute (DB, service, etc)
     */
    suspend fun <T : Any> execute(
        loader: CustomLoader.Type = CustomLoader.Type.FULL,
        service: suspend () -> ResultData<T>
    ): ResultData<T> {
        return withContext(Dispatchers.IO) {
            if (!application.checkForInternet()) {
                showError(
                    App.instance.getString(R.string.internet_conextion),
                    R.drawable.ic_error_wifi
                )
            }
            showLoader(loader)
            when (val response = service()) {
                is ResultData.Error -> {
                    hideLoader()
                    response
                }
                is ResultData.Success -> {
                    hideLoader()
                    response
                }

            }

        }
    }

    private fun showLoader(loader: CustomLoader.Type = CustomLoader.Type.FULL) {
        isLoading.set(true)
        loading.postValue(CustomLoader.LoaderConfig(true, loader))
    }


    private fun hideLoader() {
        isLoading.set(false)
        loading.postValue(CustomLoader.LoaderConfig(false))
    }

    private fun showError(
        errorMessage: String = App.instance.getString(R.string.general_error),
        @DrawableRes icon: Int = R.drawable.ic_cancel
    ) {
        showCustomAlert.postValue(
            SnackAlertView.Data.Success(
                strText = errorMessage,
                leftIcon = icon
            )
        )
    }

}