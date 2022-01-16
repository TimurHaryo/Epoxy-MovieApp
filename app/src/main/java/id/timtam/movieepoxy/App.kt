package id.timtam.movieepoxy

import android.app.Application
import com.airbnb.epoxy.Carousel
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        setupKoin()
        setupLogger()

        Carousel.setDefaultGlobalSnapHelperFactory(null)
    }

    private fun setupKoin() {

    }

    private fun setupLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}