package id.timtam.component.carousel

import android.content.Context
import android.graphics.Color
import androidx.core.view.updateLayoutParams
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import id.timtam.core.epoxy.BaseModelView

@ModelView(saveViewState = true, autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class CarouselWithBackground(context: Context) : Carousel(context), BaseModelView {

    @ModelProp(ModelProp.Option.NullOnRecycle)
    fun setCarouselBackgroundColor(color: Int?) {
        setBackgroundColor(color ?: Color.TRANSPARENT)
    }

    @ModelProp
    override fun spaceTop(space: Int) {
        updateLayoutParams<MarginLayoutParams> {
            topMargin = space
        }
    }

}