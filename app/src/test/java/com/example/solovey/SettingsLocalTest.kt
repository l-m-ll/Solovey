package com.example.solovey

import android.widget.TextView
import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SettingsLocalTest {
    @Mock
    private lateinit var volumeView: TextView
    @Mock
    private lateinit var volumeTextView: TextView
    @Mock
    private lateinit var usernameView: TextView

    @Before
    fun initSettings() {
        Settings.volumeView = volumeView
        Settings.volumeTextView = volumeTextView
        //Settings.userNameView = usernameView
    }
    @Test
    fun decVolumeValue() {
        val initValue = Settings.volume
        Settings.decrementVolume()
        assertEquals(initValue - 1, Settings.volume)
    }
    @Test
    fun decVolumeDisplay() {
        Settings.decrementVolume()
        verify(volumeView).text = Settings.volume.toString()
    }
    @Test
    fun incVolumeValue() {
        val initValue = Settings.volume
        Settings.incrementVolume()
        assertEquals(initValue + 1, Settings.volume)
    }
    @Test
    fun incVolumeDisplay() {
        Settings.incrementVolume()
        verify(volumeView).text = Settings.volume.toString()
    }
    @Test
    fun setColorViewsColor() {
        Settings.setTextColor(R.color.blue)
        verify(volumeView).setBackgroundColor(R.color.blue)
        verify(volumeTextView).setBackgroundColor(R.color.blue)
    }
    @Test
    fun getUserName() {
        assertEquals(Settings.getUserName(), Settings.getUserName())
    }
    @Test
    fun setUserNameValue() {
        var result =
        Settings.setUserName("asdf")
        assertEquals(Settings.getUserName(), "asdf")
        assertEquals(result, true)

        result = Settings.setUserName("...")
        assertEquals(Settings.getUserName(), "asdf")
        assertEquals(result, false)
    }
    @Test
    fun setNameDisplay() {
        Settings.setUserName("....")
        assert(true)
        //verify(usernameView, never()).text = Settings.getUserName()
        //Settings.setUserName("asdf")
        //verify(usernameView).text = Settings.getUserName()
    }
}