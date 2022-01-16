package id.timtam.component.banner

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import id.timtam.component.R
import id.timtam.component.databinding.ComponentMainBannerBinding
import id.timtam.component.model.EpoxySpecialEventBanner
import id.timtam.core.epoxy.BaseEpoxyModel
import id.timtam.core.epoxy.BaseHolder
import id.timtam.core.extension.gone
import id.timtam.core.extension.invisible
import id.timtam.core.extension.visible
import id.timtam.core.util.Constants

@EpoxyModelClass
abstract class MainBannerModel :
    BaseEpoxyModel<ComponentMainBannerBinding, BaseHolder<ComponentMainBannerBinding>>() {

    @EpoxyAttribute
    var bannerEvent: EpoxySpecialEventBanner? = null

    override fun getDefaultLayout(): Int = R.layout.component_main_banner

    override fun bind(holder: BaseHolder<ComponentMainBannerBinding>) {
        super.bind(holder)

        with(holder.binding) {
            when (bannerEvent?.buttonType) {
                Constants.TYPE_BANNER_VIDEO -> {
                    btnSpecialBannerExplore.invisible()
                    btnSpecialBannerVideo.visible()
                }
                Constants.TYPE_BANNER_EXPLORE -> {
                    btnSpecialBannerVideo.gone()
                    btnSpecialBannerExplore.visible()
                }
                else -> {
                    btnSpecialBannerExplore.gone()
                    btnSpecialBannerVideo.gone()
                }
            }

            specialEvent = bannerEvent
        }
    }
}