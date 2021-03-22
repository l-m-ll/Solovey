package com.example.solovey

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.solovey.settings.Settings
import org.junit.Rule
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class SettingsTest {
    @get:Rule
    val rule = ActivityScenarioRule(SettingsActivity::class.java)

    @Test
    fun componentsAreVisible() {
        onView(withId(R.id.volume_text)).check(matches(isDisplayed()))
        onView(withId(R.id.volume_value)).check(matches(isDisplayed()))
        onView(withId(R.id.snd_down)).check(matches(isDisplayed()))
        onView(withId(R.id.snd_up)).check(matches(isDisplayed()))
    }
    @Test
    fun displayVolume() {
        onView(withId(R.id.volume_value)).check(matches(withText(Settings.volume.toString())))
    }
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