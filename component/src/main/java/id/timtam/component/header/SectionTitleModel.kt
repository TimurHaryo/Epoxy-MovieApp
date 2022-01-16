package id.timtam.component.header

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import id.timtam.component.R
import id.timtam.component.databinding.ComponentSectionTitleBinding
import id.timtam.core.epoxy.BaseEpoxyModel
import id.timtam.core.epoxy.BaseHolder

@EpoxyModelClass
abstract class SectionTitleModel :
    BaseEpoxyModel<ComponentSectionTitleBinding, BaseHolder<ComponentSectionTitleBinding>>() {

    @EpoxyAttribute
    var title: String? = null

    override fun getDefaultLayout(): Int = R.layout.component_section_title

    override fun bind(holder: BaseHolder<ComponentSectionTitleBinding>) {
        super.bind(holder)

        with(holder.binding) {
            titleHeader = title
        }
    }
}