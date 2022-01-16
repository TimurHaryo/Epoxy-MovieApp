package id.timtam.movieepoxy.domain.model

import id.timtam.component.model.EpoxyMovieSnippet
import id.timtam.core.abstraction.UseComponentModel

data class MovieSnippet(
    val id: String,
    val title: String,
    val duration: String,
    val poster: String
) : UseComponentModel<EpoxyMovieSnippet> {

    override fun toComponentModel(): EpoxyMovieSnippet {
        return EpoxyMovieSnippet(id, title, duration, poster)
    }
}
