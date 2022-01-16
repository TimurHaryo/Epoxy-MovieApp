package id.timtam.component.banner

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import id.timtam.component.R
import id.timtam.component.databinding.ComponentBigFullBannerBinding
import id.timtam.core.epoxy.BaseEpoxyModel
import id.timtam.core.epoxy.BaseHolder

@EpoxyModelClass
abstract class BigFullBanner :
    BaseEpoxyModel<ComponentBigFullBannerBinding, BaseHolder<ComponentBigFullBannerBinding>>() {

    @EpoxyAttribute
    var dataTitle: String? = null

    @EpoxyAttribute
    var dataButtonTitle: String? = null

    @EpoxyAttribute
    var dataImageSource: String? = null

    override fun getDefaultLayout(): Int = R.layout.component_big_full_banner

    override fun bind(holder: BaseHolder<ComponentBigFullBannerBinding>) {
        super.bind(holder)

        with(holder.binding) {
            title = dataTitle
            buttonTitle = dataButtonTitle
            image = dataImageSource
        }
    }
}