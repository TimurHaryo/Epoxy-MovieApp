package id.timtam.core.util

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.github.ajalt.timberkt.i
import id.timtam.core.extension.loadImage

object BindingUtil {

    @JvmStatic
    @BindingAdapter("app:urlImage")
    fun setUrlImage(view: AppCompatImageView, url: String?) {
        i { "the url -> $url" }

        view.loadImage(view.context, url)
    }
}