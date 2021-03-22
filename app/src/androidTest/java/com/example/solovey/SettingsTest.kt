package com.example.solovey

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class SettingsTest {
    @get:Rule
    val rule = ActivityScenarioRule(SettingsActivity::class.java)

    @Test
    fun decVolume() {
        val initValue = Settings.volume - 1
        onView(withId(R.id.snd_down)).perform(click())
        assert(initValue == Settings.volume)
    }
    @Test
    fun incVolume() {
        val initValue = Settings.volume + 1
        onView(withId(R.id.snd_up)).perform(click())
        assert(initValue == Settings.volume)
    }
}