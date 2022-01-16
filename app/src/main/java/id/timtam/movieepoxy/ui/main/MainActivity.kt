package id.timtam.movieepoxy.ui.main

import id.timtam.core.abstraction.BaseActivityBinding
import id.timtam.movieepoxy.R
import id.timtam.movieepoxy.databinding.ActivityMainBinding
import id.timtam.movieepoxy.ui.home.HomeFragment
import id.timtam.movieepoxy.ui.main.adapter.MainMenuAdapter
import id.timtam.movieepoxy.ui.news.NewsFragment
import id.timtam.movieepoxy.ui.other.OtherFragment

class MainActivity : BaseActivityBinding<ActivityMainBinding>(R.layout.activity_main) {

    private val homeFragment: HomeFragment by lazy { HomeFragment() }
    private val newsFragment: NewsFragment by lazy { NewsFragment() }
    private val otherFragment: OtherFragment by lazy { OtherFragment() }

    private val fragments = listOf(homeFragment, newsFragment, otherFragment)

    private val mainMenuAdapter: MainMenuAdapter by lazy { MainMenuAdapter(fragments, this) }

    override fun setupView() {
        with(binding) {
            containerMain.adapter = mainMenuAdapter
            containerMain.isUserInputEnabled = false
            containerMain.offscreenPageLimit = fragments.size

            bottomNavMain.setOnItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.menuHome -> {
                        binding.containerMain.setCurrentItem(fragments.indexOf(homeFragment), false)
                        true
                    }
                    R.id.menuNews -> {
                        binding.containerMain.setCurrentItem(fragments.indexOf(newsFragment), false)
                        true
                    }
                    R.id.menuOther -> {
                        binding.containerMain.setCurrentItem(fragments.indexOf(otherFragment), false)
                        true
                    }
                    else -> false
                }
            }
        }
    }

}