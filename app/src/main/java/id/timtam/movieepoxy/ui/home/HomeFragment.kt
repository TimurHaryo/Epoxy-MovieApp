package id.timtam.movieepoxy.ui.home

import android.os.Bundle
import id.timtam.core.abstraction.BaseFragmentDataLiveNess
import id.timtam.core.extension.changeStatusBarColor
import id.timtam.core.extension.toast
import id.timtam.core.extension.weaker
import id.timtam.core.util.Constants
import id.timtam.movieepoxy.R
import id.timtam.movieepoxy.databinding.FragmentHomeBinding
import id.timtam.movieepoxy.ui.home.controller.HomeController
import id.timtam.movieepoxy.ui.home.controller.TestController
import id.timtam.movieepoxy.util.DummyData

class HomeFragment : BaseFragmentDataLiveNess<FragmentHomeBinding>(R.layout.fragment_home) {

    private val homeController: HomeController by lazy {
        HomeController(requireActivity().weaker())
    }

    private val testController: TestController by lazy {
        TestController()
    }

    override fun doWhenCreated() {
        binding.epoxyHome.setController(homeController)
        handleStatusBarColor()
    }

    override fun doWhenDisplayedOnce() {

//        testController.requestModelBuild()

        with(homeController) {
            setSpecialBanner(DummyData.getSampleSpecialBannerVideoType(requireContext()))

            setLearnMore(DummyData.getSampleLearnMore(requireContext())) {
                toast("LEARN MORE")
            }

            setBigBannerLearnMore(
                title = DummyData.getSampleBigBannerTitle(requireContext()),
                buttonTitle = DummyData.getSampleTitle(),
                image = DummyData.getSampleDarkImage(),
                type = Constants.TYPE_BANNER_BOTTOM
            )

            setLatestMovie(DummyData.getSampleMovieSnippets()) { id ->
                toast("LATEST -> $id")
            }

            setRecommendedForYou(DummyData.getSampleMovieSnippets()) { id ->
                toast("MOVIE ID -> $id")
            }

            setBuyTicketBanner(
                title = "Things to do on your cinema",
                buttonTitle = "Buy Ticket",
                image = DummyData.getSampleDarkImage(),
                type = Constants.TYPE_BANNER_TOP
            )

            setGoStreamingBanner(
                title = "Things to do on your home",
                buttonTitle = "Watch Streaming",
                image = DummyData.getSampleDarkImage(),
                type = Constants.TYPE_BANNER_TOP
            )

            setFaQBanner(
                title = "Any questions about our service?",
                buttonTitle = "Ask Question",
                image = DummyData.getSampleDarkImage()
            )

            setFooterMenus(DummyData.getSampleMenu()) { subMenuType ->
                toast("$subMenuType")
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putBundle(MOTION_HOME_STATE, binding.motionHome.transitionState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        val motionState = savedInstanceState?.getBundle(MOTION_HOME_STATE)

        motionState?.let { lastState ->
            binding.motionHome.transitionState = lastState
        }
    }

    private fun handleStatusBarColor() {
        with(binding) {
            epoxyHome.setOnScrollChangeListener { _, _, _, _, _ ->
                if (motionHome.currentState == motionHome.endState) {
                    changeStatusBarColor(requireContext().getColor(R.color.white))
                } else {
                    changeStatusBarColor(requireContext().getColor(R.color.gray_nero))
                }
            }
        }
    }

    companion object {
        private const val MOTION_HOME_STATE = "MOTION_HOME_STATE"
    }
}