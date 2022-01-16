package id.timtam.component.footer

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import id.timtam.component.R
import id.timtam.component.databinding.ComponentLearnMoreBinding
import id.timtam.core.epoxy.BaseEpoxyModel
import id.timtam.core.epoxy.BaseHolder
import id.timtam.core.extension.gone
import id.timtam.core.extension.visible

@EpoxyModelClass
abstract class LearnMoreModel :
    BaseEpoxyModel<ComponentLearnMoreBinding, BaseHolder<ComponentLearnMoreBinding>>() {

    @EpoxyAttribute
    var dataDescription: String? = null

    @EpoxyAttribute
    var onLearnMoreClick: (() -> Unit)? = null

    override fun getDefaultLayout(): Int = R.layout.component_learn_more

    override fun bind(holder: BaseHolder<ComponentLearnMoreBinding>) {
        super.bind(holder)

        with(holder.binding) {
            if (dataDescription != null) {
                description = dataDescription
                tvLearnMoreDesc.visible()
            } else {
                tvLearnMoreDesc.gone()
            }

            btnLearnMore.setOnClickListener {
                onLearnMoreClick?.invoke()
            }
        }
    }
}