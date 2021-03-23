package com.example.solovey

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.test.core.app.ActivityScenario
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest {

    @Mock private lateinit var mockActivity: Activity
    @Mock private lateinit var viewGroup: ViewGroup
    @Mock private lateinit var view: View

    @Test fun `test args define with null `() {
      val language = arrayOf("C","C++","Java")
      val description = arrayOf(
        "C programming is considered as the base for other programming languages",
        "C++ is an object-oriented programming language.",
        "Java is a programming language and a platform.",
      )
      val imageId = arrayOf<Int>(
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background,
      )
      val adapter = PlayListAdapter(PlayListActivity(), language, description, imageId)
      println(adapter.getView(33, view, viewGroup))
      Assert.assertEquals(adapter::class, PlayListAdapter::class)
    }

  }