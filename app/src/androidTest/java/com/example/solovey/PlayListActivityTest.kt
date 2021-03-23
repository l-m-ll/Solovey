package com.example.solovey

import RecyclerViewMatcher
import android.view.View
import android.widget.ListView
import androidx.annotation.NonNull
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Rule
import org.junit.Test
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onData

import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Matcher
import org.hamcrest.Matchers.*
import org.hamcrest.collection.IsMapContaining.hasEntry
import org.hamcrest.core.Is.`is`
import org.junit.runner.Description
import androidx.test.espresso.Espresso.onData





@RunWith(AndroidJUnit4::class)
class PlayListActivityTest {

    @After
    fun after() {
        Espresso.pressBackUnconditionally()
    }

    @Test
    fun test_tracksListView_visible() {
        ActivityScenario.launch(PlayListActivity::class.java)
        onView(withId(R.id.tracksListView)).check(matches(isDisplayed()))
    }

    @Test
    fun can_switch_to_play_list_activity() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.playList)).perform(click())
    }

    @Test
    fun test_tracksListView_draw_all_cells_visible() {
        ActivityScenario.launch(PlayListActivity::class.java)
        for (i in 0..2) {
            onData(anything()).inAdapterView((withId(R.id.tracksListView)))
                .atPosition(i)
                .check(matches(isDisplayed()))
        }
    }

    @Test
    fun test_tracksListView_draw_all_cells_with_right_songName() {
        ActivityScenario.launch(PlayListActivity::class.java)
        val language = arrayOf("C","C++","Java")
        val description = arrayOf(
            "C programming is considered as the base for other programming languages",
            "C++ is an object-oriented programming language.",
            "Java is a programming language and a platform.",
        )
        for (i in 0..2) {
            onData(allOf(`is`(instanceOf(String::class.java)), `is`(language[i])))
                .inAdapterView(withId(R.id.tracksListView))
                .onChildView(withId(R.id.songName))
                .check(matches(withText(description[i])))
        }

    }

    @Test
    fun test_tracksListView_draw_all_cells_clickable() {
        ActivityScenario.launch(PlayListActivity::class.java)
        val language = arrayOf("C","C++","Java")
        language.forEach {
            onData(allOf(`is`(instanceOf(String::class.java)), `is`(it)))
                .inAdapterView(withId(R.id.tracksListView))
                .perform(click())
        }
    }
}