package id.timtam.movieepoxy.ui.home.controller

import com.airbnb.epoxy.AsyncEpoxyController
import id.timtam.component.body.ContentModel_
import id.timtam.component.carousel.gridCarousel
import id.timtam.movieepoxy.util.DummyData

class TestController : AsyncEpoxyController() {
    override fun buildModels() {
        val model = DummyData.getSampleData().map {
            ContentModel_()
                .id("yeah_${it.id}")
                .model(it)
        }

        gridCarousel {
            id("test_for_fun")
            models(model)
            requestSpanCount(3)
        }
    }
}