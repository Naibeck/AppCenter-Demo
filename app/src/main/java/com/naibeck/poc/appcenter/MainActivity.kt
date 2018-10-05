package com.naibeck.poc.appcenter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAppCenter()
    }

    private fun initAppCenter() {
        AppCenter.start(application, "80c08496-d4c0-46d9-8ea8-4f5ffb569571",
                Analytics::class.java, Crashes::class.java)
    }
}
