package com.example.solovey

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Rule
import org.junit.Test


/**
   * Instrumented test, which will execute on an Android device.
   *
   * See [testing documentation](http://d.android.com/tools/testing).
   */
  @RunWith(AndroidJUnit4::class)
  class ExampleInstrumentedTest {
    //@get:Rule
    //val mActivityRule = ActivityScenarioRule(PlayListActivity::class.java)

    @After
    fun after() {
     Espresso.pressBackUnconditionally()
    }

    @Test
    fun can_switch_to_play_list_activity() {
      ActivityScenario.launch(MainActivity::class.java)
      onView(withId(R.id.playList)).perform(click())

    }

    @Test
    fun play_list_activity_listView_visible() {
      ActivityScenario.launch(PlayListActivity::class.java)
      onView(withId(R.id.tracksListView)).check(matches(isDisplayed()))
    }

    @Test
    fun play_list_activity_listView_cells_visible() {
      ActivityScenario.launch(PlayListActivity::class.java)

      onView(withId(R.id.tracksListView)).check(matches(isDisplayed()))
    }

  }