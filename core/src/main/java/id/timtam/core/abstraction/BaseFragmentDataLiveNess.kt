package id.timtam.core.abstraction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import id.timtam.core.lifecycle.SingleFetchDataLifecycle

abstract class BaseFragmentDataLiveNess<T: ViewDataBinding>(
    @LayoutRes private val resourceLayoutId: Int
) : Fragment() {

    private var _binding: T? = null

    private val singleFetchDataLifecycle by lazy {
        SingleFetchDataLifecycle(viewLifecycleOwner.lifecycle)
    }

    protected val binding: T
        get() {
            if (_binding == null) {
                throw IllegalArgumentException("${this.javaClass.simpleName} does not initialize view binding")
            }
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, resourceLayoutId, container, false)
        _binding?.lifecycleOwner = this
        _binding?.executePendingBindings()

        return requireNotNull(_binding).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(singleFetchDataLifecycle) {
            setOnInitView { doWhenCreated() }
            setOnFetchData { doWhenDisplayedOnce() }
            registerLifecycleAware()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        toBeCleared()
        _binding = null
    }

    protected abstract fun doWhenCreated()

    protected abstract fun doWhenDisplayedOnce()

    protected open fun toBeCleared() { singleFetchDataLifecycle.unregisterLifecycleAware() }
}