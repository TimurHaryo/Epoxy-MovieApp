package id.timtam.core.util

import android.graphics.Color
import java.util.*

object ResourceUtil {

    private val RANDOM = Random()

    private val darkColors = listOf(
        "#000080",
        "#008080",
        "#800080",
        "#800000",
        "#8B0000",
        "#556B2F",
        "#20B2AA",
        "#228B22",
        "#4682B4",
        "#191970",
        "#6A5ACD",
        "#8B4513",
        "#D2691E",
        "#C71585",
        "#708090"
    )

    val randomColor: Int
        get() = Color.parseColor(darkColors[RANDOM.nextInt(darkColors.size)])
}