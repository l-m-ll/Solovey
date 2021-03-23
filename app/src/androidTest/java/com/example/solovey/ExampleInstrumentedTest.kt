package com.example.solovey

import android.widget.ListView
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



  }