package com.naibeck.poc.appcenter

import android.widget.Button
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

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
        val expectedFeedback = "Pressed! Coff"
        Assert.assertEquals("Button text should shown: Pressed!", expectedFeedback, button.text.toString())
    }

}