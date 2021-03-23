package com.example.solovey

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner
import org.mockito.Mockito.`when`
import org.robolectric.RobolectricTestRunner

@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest {


  @Mock private lateinit var mockActivity: Activity
  @Mock private lateinit var viewGroup: ViewGroup
  @Mock private lateinit var view: View
  @Test
  fun test() {
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
    // access the listView from xml file
    val myListAdapter = PlayListAdapter(mockActivity, language, description, imageId)
    println(myListAdapter.getView(0, view, viewGroup))
  }

  }