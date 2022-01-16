package id.timtam.movieepoxy.domain.model

import id.timtam.component.model.EpoxyFooterMenu
import id.timtam.component.model.EpoxyFooterSubMenu
import id.timtam.core.abstraction.UseComponentModel

data class FooterMenu(
    val menu: String,
    val subMenu: List<FooterSubMenu>
) : UseComponentModel<EpoxyFooterMenu> {

    override fun toComponentModel(): EpoxyFooterMenu {
        val mappedMenu = subMenu.map {
            EpoxyFooterSubMenu(
                title = it.title,
                shortDesc = it.shortDesc,
                type = it.type
            )
        }

        return EpoxyFooterMenu(menu, mappedMenu)
    }
}