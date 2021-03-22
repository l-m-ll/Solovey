package com.example.solovey

import android.widget.TextView
import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SettingsLocalTest {
    @Mock
    private lateinit var volumeView: TextView
    @Mock
    private lateinit var volumeTextView: TextView

    @Before
    fun initSettings() {
        Settings.volumeView = volumeView
        Settings.volumeTextView = volumeTextView
    }
    @Test
    fun decVolume() {
        val initValue = Settings.volume
        Settings.decrementVolume()
        verify(volumeView).text = Settings.volume.toString()
        assertEquals(initValue - 1, Settings.volume)
    }
    @Test
    fun incVolume() {
        val initValue = Settings.volume
        Settings.incrementVolume()
        verify(volumeView).text = Settings.volume.toString()
        assertEquals(initValue + 1, Settings.volume)
    }
    @Test
    fun setColorViewsColor() {
        Settings.setTextColor(R.color.blue)
        verify(volumeView).setBackgroundColor(R.color.blue)
        verify(volumeTextView).setBackgroundColor(R.color.blue)
    }
    @Test
    fun setUserName() {
        var result =
        Settings.setUserName("asdf")
        assertEquals(Settings.getUserName(), "asdf")
        assertEquals(result, true)

        result = Settings.setUserName("...")
        assertEquals(Settings.getUserName(), "asdf")
        assertEquals(result, false)
    }
}