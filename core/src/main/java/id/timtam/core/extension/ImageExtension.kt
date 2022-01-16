package id.timtam.core.extension

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy

fun ImageView.loadImage(context: Context, source: String?) {
    Glide.with(context)
        .load(source)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .dontAnimate()
        .priority(Priority.HIGH)
        .into(this)
}

fun ImageView.loadImage(context: Context, source: Int?) {
    Glide.with(context)
        .load(source)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .into(this)
}