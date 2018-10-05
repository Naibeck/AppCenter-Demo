package com.naibeck.poc.appcenter

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import com.microsoft.appcenter.push.Push


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAppCenter()

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            Analytics.trackEvent("CTA clicked")
            button.text = getString(R.string.pressed_feedback)
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        when (newConfig?.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> Analytics.trackEvent("Landscape rotation")
            Configuration.ORIENTATION_PORTRAIT -> Analytics.trackEvent("Portrait rotation")
        }
    }

    private fun initAppCenter() {
        AppCenter.start(application, "80c08496-d4c0-46d9-8ea8-4f5ffb569571",
                Analytics::class.java, Crashes::class.java, Analytics::class.java, Push::class.java)
    }
}
