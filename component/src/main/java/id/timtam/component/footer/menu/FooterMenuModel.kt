package id.timtam.component.footer.menu

import android.view.ViewGroup
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import id.timtam.component.R
import id.timtam.component.databinding.ComponentFooterMenuBinding
import id.timtam.component.footer.menu.adapter.FooterSubMenuAdapter
import id.timtam.component.model.EpoxyFooterMenu
import id.timtam.component.util.SubMenuType
import id.timtam.core.epoxy.BaseEpoxyModel
import id.timtam.core.epoxy.BaseHolder

@EpoxyModelClass
abstract class FooterMenuModel :
    BaseEpoxyModel<ComponentFooterMenuBinding, BaseHolder<ComponentFooterMenuBinding>>() {

    @EpoxyAttribute
    var dataMenu: EpoxyFooterMenu? = null

    @EpoxyAttribute
    var inLastItem: Boolean = false

    @EpoxyAttribute
    var onMenuClicked: ((SubMenuType?) -> Unit)? = null

    private val subMenuAdapter: FooterSubMenuAdapter by lazy { FooterSubMenuAdapter() }

    override fun getDefaultLayout(): Int = R.layout.component_footer_menu

    override fun bind(holder: BaseHolder<ComponentFooterMenuBinding>) {
        super.bind(holder)

        with(holder.binding) {
            titleMenu = dataMenu?.menu

            subMenuAdapter.setOnClickMenu(onMenuClicked)
            subMenuAdapter.setData(dataMenu?.subMenu.orEmpty())

            if (inLastItem) {
                parentFooterMenu.layoutParams.width = ViewGroup.MarginLayoutParams.MATCH_PARENT
            }

            rvFooterMenu.adapter = subMenuAdapter
            rvFooterMenu.setHasFixedSize(true)
        }
    }
}