package id.timtam.component.banner

import android.graphics.Color
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import id.timtam.component.R
import id.timtam.component.databinding.ComponentCardBigBannerBinding
import id.timtam.core.epoxy.BaseEpoxyModel
import id.timtam.core.epoxy.BaseHolder
import id.timtam.core.extension.gone
import id.timtam.core.extension.visible
import id.timtam.core.util.Constants

@EpoxyModelClass
abstract class CardBigBannerModel :
    BaseEpoxyModel<ComponentCardBigBannerBinding, BaseHolder<ComponentCardBigBannerBinding>>() {

    @EpoxyAttribute
    var dataTitle: String? = null

    @EpoxyAttribute
    var dataButtonTitle: String? = null

    @EpoxyAttribute
    var dataImageSource: String? = null

    @EpoxyAttribute
    var topSectionBackground: Int? = null

    @EpoxyAttribute
    var bottomSectionBackground: Int? = null

    @EpoxyAttribute
    var type: String? = null

    override fun getDefaultLayout(): Int = R.layout.component_card_big_banner

    override fun bind(holder: BaseHolder<ComponentCardBigBannerBinding>) {
        super.bind(holder)

        with(holder.binding) {
            title = dataTitle
            buttonTitle = dataButtonTitle
            imageSource = dataImageSource

            viewTopBigBanner.setBackgroundColor(topSectionBackground ?: Color.TRANSPARENT)
            viewBottomBigBanner.setBackgroundColor(bottomSectionBackground ?: Color.TRANSPARENT)

            when (type) {
                Constants.TYPE_BANNER_BOTTOM -> {
                    groupTopRedaction.gone()
                    groupBottomRedaction.visible()
                }
                Constants.TYPE_BANNER_TOP -> {
                    groupBottomRedaction.gone()
                    groupTopRedaction.visible()
                }
                else -> {
                    groupTopRedaction.gone()
                    groupBottomRedaction.gone()
                }
            }
        }
    }
}