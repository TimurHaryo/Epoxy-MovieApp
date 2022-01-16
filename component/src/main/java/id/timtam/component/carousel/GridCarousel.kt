package id.timtam.component.carousel

import android.content.Context
import androidx.annotation.IntRange
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.AfterPropsSet
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView

@ModelView(saveViewState = true, autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class GridCarousel(context: Context) : Carousel(context) {

    private var requestedSpanCount: Int = DEFAULT_SPAN_COUNT

    @ModelProp(defaultValue = "DEFAULT_SPAN_COUNT")
    fun requestSpanCount(@IntRange(from = 2) spanCount: Int) {
        this.requestedSpanCount = spanCount
    }

    @AfterPropsSet
    fun build() {
        layoutManager = GridLayoutManager(
            context,
            requestedSpanCount,
            LinearLayoutManager.HORIZONTAL,
            false
        )
    }

    companion object {
        const val DEFAULT_SPAN_COUNT = 2
    }

}