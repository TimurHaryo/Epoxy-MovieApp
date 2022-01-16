package id.timtam.movieepoxy.ui.home.controller

import android.app.Activity
import com.airbnb.epoxy.*
import id.timtam.component.R
import id.timtam.component.banner.CardMediumSimpleBannerModel_
import id.timtam.component.banner.bigFullBanner
import id.timtam.component.banner.cardBigBanner
import id.timtam.component.banner.mainBanner
import id.timtam.component.body.ContentCircleModel_
import id.timtam.component.carousel.carouselWithBackground
import id.timtam.component.carousel.gridCarousel
import id.timtam.component.footer.learnMore
import id.timtam.component.footer.menu.FooterMenuModel_
import id.timtam.component.header.sectionTitle
import id.timtam.component.util.SubMenuType
import id.timtam.core.extension.dp
import id.timtam.movieepoxy.domain.model.FooterMenu
import id.timtam.movieepoxy.domain.model.MovieSnippet
import id.timtam.movieepoxy.domain.model.SpecialEventBanner
import java.lang.ref.WeakReference

class HomeController(
    weakActivity: WeakReference<Activity>
) : AsyncEpoxyController() {

    private val activity = weakActivity.get()

    private var specialEventBanner: SpecialEventBanner? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    private var learnMoreDesc: String? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    private var onLearnMoreClick: (() -> Unit)? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    private var bannerLearnMoreTitle: String? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    private var bannerLearnMoreButtonTitle: String? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    private var bannerLearnMoreImage: String? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    private var bannerLearnMoreType: String? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    private var footerMenu: List<FooterMenu> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }

    private var onFooterMenuClicked: ((SubMenuType?) -> Unit)? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    private var recommendedMovies: List<MovieSnippet> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }

    private var onRecommendedMovieClicked: ((String) -> Unit)? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    private var latestMovies: List<MovieSnippet> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }

    private var onLatestMovieClicked: ((String) -> Unit)? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    private var bannerBuyTicketTitle: String? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    private var bannerBuyTicketButtonTitle: String? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    private var bannerBuyTicketImage: String? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    private var bannerBuyTicketType: String? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    private var bannerGoStreamingTitle: String? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    private var bannerGoStreamingButtonTitle: String? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    private var bannerGoStreamingImage: String? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    private var bannerGoStreamingType: String? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    private var bannerFaQTitle: String? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    private var bannerFaQButtonTitle: String? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    private var bannerFaQImage: String? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {

        renderMainBanner()

        renderLearnMore()

        renderBigBanner()

        renderLatestMovies()

        renderRecommendedMovies()

        renderWhatToDo()

        renderFaQ()

        renderFooterMenu()

    }

    fun setSpecialBanner(data: SpecialEventBanner) {
        this.specialEventBanner = data
    }

    fun setLearnMore(desc: String?, action: () -> Unit) {
        this.learnMoreDesc = desc
        this.onLearnMoreClick = action
    }

    fun setBigBannerLearnMore(
        title: String,
        buttonTitle: String,
        image: String?,
        type: String?
    ) {
        this.bannerLearnMoreTitle = title
        this.bannerLearnMoreButtonTitle = buttonTitle
        this.bannerLearnMoreImage = image
        this.bannerLearnMoreType = type
    }

    fun setLatestMovie(
        movies: List<MovieSnippet>,
        action: (String) -> Unit
    ) {
        this.latestMovies = movies
        this.onLatestMovieClicked = action
    }

    fun setRecommendedForYou(
        movies: List<MovieSnippet>,
        action: (String) -> Unit
    ) {
        this.recommendedMovies = movies
        this.onRecommendedMovieClicked = action
    }

    fun setBuyTicketBanner(
        title: String,
        buttonTitle: String,
        image: String?,
        type: String?
    ) {
        this.bannerBuyTicketTitle = title
        this.bannerBuyTicketButtonTitle = buttonTitle
        this.bannerBuyTicketImage = image
        this.bannerBuyTicketType = type
    }

    fun setGoStreamingBanner(
        title: String,
        buttonTitle: String,
        image: String?,
        type: String?
    ) {
        this.bannerGoStreamingTitle = title
        this.bannerGoStreamingButtonTitle = buttonTitle
        this.bannerGoStreamingImage = image
        this.bannerGoStreamingType = type
    }

    fun setFaQBanner(
        title: String,
        buttonTitle: String,
        image: String?
    ) {
        this.bannerFaQTitle = title
        this.bannerFaQButtonTitle = buttonTitle
        this.bannerFaQImage = image
    }

    fun setFooterMenus(
        menus: List<FooterMenu>,
        action: (SubMenuType?) -> Unit
    ) {
        this.footerMenu = menus
        this.onFooterMenuClicked = action
    }

    private fun renderMainBanner() {
        mainBanner {
            id("main_banner_home")
            bannerEvent(this@HomeController.specialEventBanner?.toComponentModel())
        }
    }

    private fun renderLearnMore() {
        learnMore {
            id("learn_more_home")
            dataDescription(this@HomeController.learnMoreDesc)
            onLearnMoreClick(this@HomeController.onLearnMoreClick)
            backgroundColor(this@HomeController.activity?.getColor(R.color.black))
        }
    }

    private fun renderBigBanner() {
        cardBigBanner {
            id("big_banner_home_hottest")
            dataTitle(this@HomeController.bannerLearnMoreTitle)
            dataButtonTitle(this@HomeController.bannerLearnMoreButtonTitle)
            dataImageSource(this@HomeController.bannerLearnMoreImage)
            topSectionBackground(this@HomeController.activity?.getColor(R.color.black))
            type(this@HomeController.bannerLearnMoreType)
        }
    }

    private fun renderLatestMovies() {
        sectionTitle {
            id("section_latest_movie")
            title("Fresh and Hot")
            spaceTop(32.dp)
            spaceBottom(12.dp)
        }

        val model = latestMovies.map { movie ->
            ContentCircleModel_()
                .id("latest_movie_${movie.hashCode()}")
                .dataMovie(movie.toComponentModel())
                .onContentClicked(onLatestMovieClicked)
                .spaceTop(4.dp)
                .spaceBottom(4.dp)
        }

        gridCarousel {
            id(ID_CAROUSEL_LATEST_MOVIE)
            padding(Carousel.Padding.dp(10, 0, 10, 0, 0))
            models(model)
            requestSpanCount(2)
            numViewsToShowOnScreen(1.1f)
        }
    }

    private fun renderRecommendedMovies() {
        sectionTitle {
            id("section_recommended_movie")
            title("Recommended For You")
            spaceTop(32.dp)
        }

        val model = recommendedMovies.map { movie ->
            CardMediumSimpleBannerModel_()
                .id("rec_movie_${movie.hashCode()}")
                .dataMovie(movie.toComponentModel())
                .onClickBanner(onRecommendedMovieClicked)
        }

        carousel {
            id(ID_CAROUSEL_RECOMMENDED_MOVIE)
            padding(Carousel.Padding.dp(18, 12, 18, 0, 16))
            models(model)
        }
    }

    private fun renderWhatToDo() {
        sectionTitle {
            id("section_home_what_to_do")
            title("What To Do?")
            spaceTop(32.dp)
            spaceBottom(12.dp)
        }

        cardBigBanner {
            id("big_banner_home_go_buy_ticket")
            dataTitle(this@HomeController.bannerBuyTicketTitle)
            dataButtonTitle(this@HomeController.bannerBuyTicketButtonTitle)
            dataImageSource(this@HomeController.bannerBuyTicketImage)
            type(this@HomeController.bannerBuyTicketType)
        }

        cardBigBanner {
            id("big_banner_home_go_streaming")
            dataTitle(this@HomeController.bannerGoStreamingTitle)
            dataButtonTitle(this@HomeController.bannerGoStreamingButtonTitle)
            dataImageSource(this@HomeController.bannerGoStreamingImage)
            type(this@HomeController.bannerGoStreamingType)
        }
    }

    private fun renderFaQ() {
        bigFullBanner {
            id("full_banner_faq")
            dataTitle(this@HomeController.bannerFaQTitle)
            dataButtonTitle(this@HomeController.bannerFaQButtonTitle)
            dataImageSource(this@HomeController.bannerFaQImage)
            spaceTop(32.dp)
        }
    }

    private fun renderFooterMenu() {
        val modelMenu = footerMenu.mapIndexed { index, menu ->
            FooterMenuModel_()
                .id("menu_${menu.hashCode()}")
                .dataMenu(menu.toComponentModel())
                .inLastItem(index == footerMenu.lastIndex)
                .onMenuClicked(onFooterMenuClicked)
        }

        carouselWithBackground {
            id(ID_CAROUSEL_FOOTER_MENU)
            padding(Carousel.Padding.dp(10, 0, 10, 0, 0))
            models(modelMenu)
            carouselBackgroundColor(this@HomeController.activity?.getColor(R.color.gray_vanilla))
        }
    }

    companion object {
        private const val ID_CAROUSEL_LATEST_MOVIE = "carousel_latest_movie"
        private const val ID_CAROUSEL_RECOMMENDED_MOVIE = "carousel_recommended_movie"
        private const val ID_CAROUSEL_FOOTER_MENU = "carousel_footer_menu"
    }

}