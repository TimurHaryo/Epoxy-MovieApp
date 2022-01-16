package id.timtam.movieepoxy.util

import android.content.Context
import id.timtam.component.util.SubMenuType
import id.timtam.core.util.Constants
import id.timtam.core.util.SampleModel
import id.timtam.movieepoxy.R
import id.timtam.movieepoxy.domain.model.FooterMenu
import id.timtam.movieepoxy.domain.model.FooterSubMenu
import id.timtam.movieepoxy.domain.model.MovieSnippet
import id.timtam.movieepoxy.domain.model.SpecialEventBanner

object DummyData {

    private val sampleMovieSnippet = MovieSnippet(
        id = "123",
        title = "The Eternal",
        duration = "2 Hours 3 Minutes",
        poster = "https://c4.wallpaperflare.com/wallpaper/622/226/375/river-girl-silhouette-forest-wallpaper-preview.jpg"
    )

    fun getSampleBigBannerTitle(context: Context) = context.getString(R.string.not_sure_to_go)

    fun getSampleTitle() = "I'm Flexible"

    fun getSampleDarkImage() = "https://c4.wallpaperflare.com/wallpaper/622/226/375/river-girl-silhouette-forest-wallpaper-preview.jpg"

    fun getSampleData() = listOf(
        SampleModel(1, "Header", "Category 1"),
        SampleModel(11, "Content", "Hello World"),
        SampleModel(12, "Content", "Lorem-Ipsum"),
        SampleModel(13, "Content", "Hello Android"),
        SampleModel(2, "Header", "Category 2"),
        SampleModel(21, "Content", "Hello World"),
        SampleModel(22, "Content", "Lorem-Ipsum"),
        SampleModel(23, "Content", "Hello Android"),
        SampleModel(3, "Header", "Category 3"),
        SampleModel(31, "Content", "Hello World"),
        SampleModel(32, "Content", "Lorem-Ipsum"),
        SampleModel(33, "Content", "Hello Android"),
        SampleModel(4, "Header", "Category 4"),
        SampleModel(41, "Content", "Hello World"),
        SampleModel(42, "Content", "Lorem-Ipsum"),
        SampleModel(43, "Content", "Hello Android"),
        SampleModel(5, "Footer", "End of list"),
    )

    fun getSampleSpecialBannerVideoType(context: Context) = SpecialEventBanner(
        bigBanner = "https://nawalakarsa.id/wp-content/uploads/2020/12/1-scaled.jpg",
        titlePicture = "https://a0.muscache.com/im/pictures/1d7b26b6-bb4f-4fe2-8ef7-0d91c20c6699.jpg",
        titleText = context.getString(R.string.winter_release),
        buttonType = Constants.TYPE_BANNER_VIDEO
    )

    fun getSampleSpecialBannerExploreType(context: Context) = SpecialEventBanner(
        bigBanner = "https://nawalakarsa.id/wp-content/uploads/2020/12/1-scaled.jpg",
        titlePicture = "https://a0.muscache.com/im/pictures/1d7b26b6-bb4f-4fe2-8ef7-0d91c20c6699.jpg",
        titleText = context.getString(R.string.winter_release),
        buttonType = Constants.TYPE_BANNER_EXPLORE
    )

    fun getSampleLearnMore(context: Context) = context.getString(R.string.learn_more_winter_release)

    fun getSampleMenu() = listOf(
        FooterMenu(
            menu = "Support",
            subMenu = listOf(
                FooterSubMenu(
                    title = "Help Center",
                    shortDesc = "Get Help",
                    type = SubMenuType.SUPPORT_HELP_CENTER
                ),
                FooterSubMenu(
                    title = "Help Center 2",
                    shortDesc = "Get Help 2",
                    type = SubMenuType.SUPPORT_CANCELLATION
                ),
                FooterSubMenu(
                    title = "Help Center 0",
                    shortDesc = "Get Help 0",
                    type = SubMenuType.SUPPORT_COVID_RESPONSE
                )
            )
        ),
        FooterMenu(
            menu = "Hosting",
            subMenu = listOf(
                FooterSubMenu(
                    title = "Help Center 3",
                    shortDesc = "Get Help 3",
                    type = SubMenuType.HOSTING_AIR_COVER
                ),
                FooterSubMenu(
                    title = "Help Center 4",
                    shortDesc = "Get Help 4",
                    type = SubMenuType.HOSTING_EXPLORE
                )
            )
        ),
        FooterMenu(
            menu = "About",
            subMenu = listOf(
                FooterSubMenu(
                    title = "Help Center 5",
                    shortDesc = "Get Help 5",
                    type = SubMenuType.ABOUT_NEWSROOM
                ),
                FooterSubMenu(
                    title = "Help Center 6",
                    shortDesc = "Get Help 6",
                    type = SubMenuType.ABOUT_WINTER_RELEASE
                )
            )
        )
    )

    fun getSampleMovieSnippets() = listOf(
        sampleMovieSnippet,
        sampleMovieSnippet,
        sampleMovieSnippet,
        sampleMovieSnippet,
        sampleMovieSnippet,
        sampleMovieSnippet,
        sampleMovieSnippet
    )
}