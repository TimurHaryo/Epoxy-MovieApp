package id.timtam.movieepoxy.domain.model

import id.timtam.component.model.EpoxyFooterSubMenu
import id.timtam.component.util.SubMenuType
import id.timtam.core.abstraction.UseComponentModel

data class FooterSubMenu(
    val title: String,
    val shortDesc: String,
    val type: SubMenuType?
) : UseComponentModel<EpoxyFooterSubMenu> {

    override fun toComponentModel(): EpoxyFooterSubMenu {
        return EpoxyFooterSubMenu(title, shortDesc, type)
    }

}