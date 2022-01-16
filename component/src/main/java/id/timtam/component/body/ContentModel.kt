package id.timtam.component.body

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import id.timtam.component.R
import id.timtam.component.databinding.ComponentContentBinding
import id.timtam.core.epoxy.BaseHolder
import id.timtam.core.util.SampleModel

@EpoxyModelClass
abstract class ContentModel: EpoxyModelWithHolder<BaseHolder<ComponentContentBinding>>() {

    @EpoxyAttribute
    var model: SampleModel? = null

    @EpoxyAttribute
    var onContentClick: (() -> Unit)? = null

    override fun getDefaultLayout(): Int = R.layout.component_content

    override fun bind(holder: BaseHolder<ComponentContentBinding>) {
        super.bind(holder)

        with(holder.binding) {
            sampleModelVariable = model
            root.setOnClickListener {
                onContentClick?.invoke()
            }
        }
    }
}