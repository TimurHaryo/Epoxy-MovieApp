package id.timtam.core.epoxy

import android.view.View
import android.view.ViewGroup
import androidx.core.view.updateLayoutParams
import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelWithHolder

abstract class BaseEpoxyModel<B: ViewDataBinding, H: BaseHolder<B>> : EpoxyModelWithHolder<H>() {

    @EpoxyAttribute
    var spaceTop: Int? = null

    @EpoxyAttribute
    var spaceBottom: Int? = null

    @EpoxyAttribute
    var backgroundColor: Int? = null

    override fun shouldSaveViewState(): Boolean = true

    override fun bind(holder: H) {
        super.bind(holder)

        updateBackgroundColor(holder.binding.root)
        updateMarginVertical(holder.binding.root)
    }

    private fun updateBackgroundColor(view: View) {
        backgroundColor?.let {
            view.setBackgroundColor(it)
        }
    }

    private fun updateMarginVertical(view: View) {
        if (spaceTop == null && spaceBottom == null) return

        spaceTop?.let {
            view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                topMargin = it
            }
        }

        spaceBottom?.let {
            view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                bottomMargin = it
            }
        }
    }
}