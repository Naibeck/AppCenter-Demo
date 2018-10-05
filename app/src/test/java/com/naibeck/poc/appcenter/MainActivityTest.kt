package com.naibeck.poc.appcenter

import android.content.res.Configuration
import android.widget.Button
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    @Test
    fun `Button text should be changed to Pressed! after clicked`() {
        // Setup
        val activity = Robolectric.setupActivity(MainActivity::class.java)
        val button = activity.findViewById<Button>(R.id.button)

        // Exercise
        button.performClick()

        // Validation
        val expectedFeedback = "Pressed!"
        Assert.assertEquals("Button text should shown: Pressed!", expectedFeedback, button.text.toString())
    }

    @Test @Config(qualifiers = "port")
    fun `Detect configuration change from portrait to landscape`() {
        // Setup
        val controller = Robolectric.buildActivity(MainActivity::class.java)

        // Exercise
        RuntimeEnvironment.setQualifiers("land")
        controller.configurationChange()

        // Validation
        val expectedOrientation = Configuration.ORIENTATION_LANDSCAPE
        Assert.assertEquals("Configuration should be landscape", expectedOrientation,
                controller.get().resources.configuration.orientation)
    }

    @Test @Config(qualifiers = "land")
    fun `Detect configuration change from landscape to portrait`() {
        // Setup
        val controller = Robolectric.buildActivity(MainActivity::class.java)

        // Exercise
        RuntimeEnvironment.setQualifiers("port")
        controller.configurationChange()

        // Validation
        val expectedOrientation = Configuration.ORIENTATION_PORTRAIT
        Assert.assertEquals("Configuration should be landscape", expectedOrientation,
                controller.get().resources.configuration.orientation)
    }
}