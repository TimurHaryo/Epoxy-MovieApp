package id.timtam.movieepoxy.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import id.timtam.core.abstraction.BaseActivityBinding
import id.timtam.core.extension.runAfterDelay
import id.timtam.movieepoxy.R
import id.timtam.movieepoxy.databinding.ActivitySplashBinding
import id.timtam.movieepoxy.ui.main.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivityBinding<ActivitySplashBinding>(R.layout.activity_splash) {

    override fun setupView() {
        runAfterDelay(2000L) {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}