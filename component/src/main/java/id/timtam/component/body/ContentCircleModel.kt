package id.timtam.component.body

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import id.timtam.component.R
import id.timtam.component.databinding.ComponentContentCircleBinding
import id.timtam.component.model.EpoxyMovieSnippet
import id.timtam.core.epoxy.BaseEpoxyModel
import id.timtam.core.epoxy.BaseHolder

@EpoxyModelClass
abstract class ContentCircleModel
    : BaseEpoxyModel<ComponentContentCircleBinding, BaseHolder<ComponentContentCircleBinding>>() {

    @EpoxyAttribute
    var dataMovie: EpoxyMovieSnippet? = null

    @EpoxyAttribute
    var onContentClicked: ((String) -> Unit)? = null

    override fun getDefaultLayout(): Int = R.layout.component_content_circle

    override fun bind(holder: BaseHolder<ComponentContentCircleBinding>) {
        super.bind(holder)

        with(holder.binding) {
            movie = dataMovie

            root.setOnClickListener {
                onContentClicked?.invoke(dataMovie?.id.orEmpty())
            }
        }
    }
}