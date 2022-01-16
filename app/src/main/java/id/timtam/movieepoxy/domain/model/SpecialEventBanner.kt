package id.timtam.movieepoxy.domain.model

import id.timtam.component.model.EpoxySpecialEventBanner
import id.timtam.core.abstraction.UseComponentModel

data class SpecialEventBanner(
    val bigBanner: String,
    val titlePicture: String,
    val titleText: String,
    val buttonType: String?
) : UseComponentModel<EpoxySpecialEventBanner> {

    override fun toComponentModel(): EpoxySpecialEventBanner {
        return EpoxySpecialEventBanner(bigBanner, titlePicture, titleText, buttonType)
    }

    companion object {
        val empty = SpecialEventBanner("", "", "", "")
    }
}
