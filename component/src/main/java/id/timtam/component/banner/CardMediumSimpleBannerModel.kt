package id.timtam.component.banner

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import id.timtam.component.R
import id.timtam.component.databinding.ComponentCardMediumSimpleBannerBinding
import id.timtam.component.model.EpoxyMovieSnippet
import id.timtam.core.epoxy.BaseEpoxyModel
import id.timtam.core.epoxy.BaseHolder
import id.timtam.core.util.ResourceUtil

@EpoxyModelClass
abstract class CardMediumSimpleBannerModel :
    BaseEpoxyModel<ComponentCardMediumSimpleBannerBinding, BaseHolder<ComponentCardMediumSimpleBannerBinding>>() {

    @EpoxyAttribute
    var dataMovie: EpoxyMovieSnippet? = null

    @EpoxyAttribute
    var onClickBanner: ((String) -> Unit)? = null

    override fun getDefaultLayout(): Int = R.layout.component_card_medium_simple_banner

    override fun bind(holder: BaseHolder<ComponentCardMediumSimpleBannerBinding>) {
        super.bind(holder)

        with(holder.binding) {

            movie = dataMovie
            cardMediumSimpleBanner.setCardBackgroundColor(ResourceUtil.randomColor)

            root.setOnClickListener {
                onClickBanner?.invoke(dataMovie?.id.orEmpty())
            }
        }
    }
}