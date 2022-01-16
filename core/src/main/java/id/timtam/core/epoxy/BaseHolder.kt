package id.timtam.core.epoxy

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.EpoxyHolder

class BaseHolder<T: ViewDataBinding> : EpoxyHolder() {

    private var _binding: T? = null

    val binding: T
        get() {
            if (_binding == null) {
                throw IllegalArgumentException("${this.javaClass.simpleName} does not initialize view binding")
            }
            return _binding!!
        }

    override fun bindView(itemView: View) {
        _binding = DataBindingUtil.bind(itemView)
    }
}