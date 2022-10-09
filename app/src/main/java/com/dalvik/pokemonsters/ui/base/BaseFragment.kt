package com.dalvik.pokemonsters.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dalvik.pokemonsters.utils.CustomLoader
import com.dalvik.pokemonsters.utils.SnackAlertView

/**
 * Use this whenever you create a new Fragment
 */

abstract class BaseFragment<BINDING : ViewDataBinding, VIEW_MODEL : BaseViewModel, ACTIVITY_VIEW_MODEL : BaseViewModel>(
    private val viewModelClass: Class<VIEW_MODEL>,
    private val activityViewModelClass: Class<ACTIVITY_VIEW_MODEL>
) : Fragment() {
    private val loader: CustomLoader by lazy { CustomLoader(requireContext(), null) }
    private val snackView: SnackAlertView by lazy { SnackAlertView(requireContext()) }

    lateinit var activityViewModel: ACTIVITY_VIEW_MODEL

    private var _binding: BINDING? = null
    private var _viewModel: VIEW_MODEL? = null
    protected val binding: BINDING
        get() = _binding ?: throw RuntimeException("Binding must be non-null")
    protected val viewModel: VIEW_MODEL get() = ViewModelProvider(this)[viewModelClass]
    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> BINDING

    private var isInitialized = false

    /**
     * LiveData to notify a activity/fragment when service is start/end to block UI if necessary
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        if (_binding == null) _binding = bindingInflater.invoke(inflater, container, false)
        return requireNotNull(_binding).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!isInitialized) {
            isInitialized = true
            binding.lifecycleOwner = this
            bindViewModel(binding, viewModel)
            setupUiBehavior()
            subscribeToEvents()
            subscribeToBaseEvents()
        }
    }

    /**
     * If you enable this, and then access parent view model, it will crash
     */
    open fun ignoreParentViewMode(): Boolean {
        return false
    }

    /**
     * Override if you receive arguments (Only called if arguments != null)
     */
    open fun getArgs() {
        //do nothing
    }

    /**
     * Override if no arguments are found
     */
    open fun noArgs() {
        //do nothing
    }

    abstract fun bindViewModel(binding: BINDING, viewModel: VIEW_MODEL)

    /**
     * Use this function to set click listeners and other ui elements events
     */
    abstract fun setupUiBehavior()

    /**
     * Use this function to observe viewmodel events
     */
    abstract fun subscribeToEvents()


    private fun showLoader(config: CustomLoader.LoaderConfig) {
        loader.show(config)
    }


    private fun hideLoader() {
        loader.hide()
    }

    open fun showAlertView(data: SnackAlertView.Data) {
        snackView.load(
            data = data
        )
    }

    private fun subscribeToBaseEvents() {
        viewModel.loading.observe(requireActivity()) {
            if (it.visible) showLoader(it) else hideLoader()
        }
        viewModel.showCustomAlert.observe(requireActivity()) {
            showAlertView(
                it
            )
        }
    }


}
