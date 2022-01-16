package id.timtam.component.footer.menu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import id.timtam.component.R
import id.timtam.component.databinding.ItemSubMenuBinding
import id.timtam.component.model.EpoxyFooterSubMenu
import id.timtam.component.util.SubMenuType
import id.timtam.core.abstraction.RecyclerViewAdapter
import id.timtam.core.abstraction.ViewHolder

class FooterSubMenuAdapter :
    RecyclerViewAdapter<FooterSubMenuAdapter.FooterSubMenuViewHolder, EpoxyFooterSubMenu>() {

    private var onClickMenu: ((SubMenuType?) -> Unit)? = null

    override val holderInflater: (LayoutInflater, ViewGroup, Boolean) -> FooterSubMenuViewHolder
        get() = { layoutInflater, viewGroup, b ->
            FooterSubMenuViewHolder(
                onClickMenu,
                DataBindingUtil.inflate(layoutInflater, R.layout.item_sub_menu, viewGroup, b)
            )
        }

    override fun onBindViewHolder(holder: FooterSubMenuViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    fun setOnClickMenu(action: ((SubMenuType?) -> Unit)?) {
        this.onClickMenu = action
    }

    class FooterSubMenuViewHolder(
        private val action: ((SubMenuType?) -> Unit)?,
        itemView: ItemSubMenuBinding
    ) : ViewHolder<ItemSubMenuBinding, EpoxyFooterSubMenu>(itemView) {

        override fun bind(data: EpoxyFooterSubMenu) {
            with(binding) {
                title = data.title
                shortDesc = data.shortDesc

                root.setOnClickListener {
                    action?.invoke(data.type)
                }
            }
        }
    }
}