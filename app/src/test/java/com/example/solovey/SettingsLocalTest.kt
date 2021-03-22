package com.example.solovey

import android.widget.TextView
import com.example.solovey.settings.Settings
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SettingsLocalTest {
    @Mock
    private lateinit var volumeView: TextView

    @Before
    fun initSettings() {
        Settings.volumeView = volumeView
    }
    @Test
    fun decVolume() {
        Settings.decrementVolume()
        verify(volumeView).text = Settings.volume.toString()
    }
    @Before
    fun initSettings1() {
        Settings.volumeView = volumeView
    }
    @Test
    fun incVolume() {
        Settings.incrementVolume()
        verify(volumeView).text = Settings.volume.toString()
    }
}