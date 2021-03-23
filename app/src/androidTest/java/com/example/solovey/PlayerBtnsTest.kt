package com.example.solovey

import android.graphics.ColorSpace.match
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Assert.assertNotEquals
import org.junit.Rule
import org.junit.Test

class PlayerBtnsTest {
    @get:Rule
    val rule = ActivityScenarioRule(activity_play::class.java)

    @Test
    fun checkBtnsExistance() {
        onView(withId(R.id.pause)).check(matches(isDisplayed()))
        onView(withId(R.id.gofor)).check(matches(isDisplayed()))
        onView(withId(R.id.goback)).check(matches(isDisplayed()))
        onView(withId(R.id.timeBar)).check(matches(isDisplayed()))
    }

    @Test
    fun getFirstSong () {
        var storage = MusicStorageTest()
        var song = storage.next()
        var songName = storage.getName()
        assertEquals("songs name should be the same", songName, "Solovey 1")
    }

    @Test
    fun initPlayer() {
        var player = MediaPlayerStub();
        var storage = MusicStorageTest()
        var song = storage.next()
        var songName = storage.getName()
        player.initPlayer(song, songName)
        assertEquals( "player should be playing", true, player.isSongPlaying())
        assertEquals("song names should be the same", songName, player.getSongName())
        assertEquals("songs should be the same", song, player.getSongPlaying())
        player.releasePlayer()
    }

    @Test
    fun releasePlayer () {
        var player = MediaPlayerStub();
        player.startPlayer()
        player.releasePlayer()
        assertEquals( "player should not be playing", false, player.isSongPlaying())
    }

    @Test
    fun clickPauseBtn() {
        var player = MediaPlayerStub();
        player.startPlayer()
        assertEquals( "player should be playing", true, player.isSongPlaying())
        player.clickPlayBtn()
        assertEquals( "player should not be playing", false, player.isSongPlaying())
        player.clickPlayBtn()
        assertEquals( "player should be playing", true, player.isSongPlaying())
        player.releasePlayer()
    }

    @Test
    fun clickGoForBtn() {
        var player = MediaPlayerStub();
        player.startPlayer()
        assertEquals("song names should be the same", "Solovey 1", player.getSongName())
        player.goFor()
        assertEquals("song names should be the same", "Another Solovey", player.getSongName())
        player.releasePlayer()
    }

    @Test
    fun clickGoBackBtn() {
        var player = MediaPlayerStub();
        player.startPlayer()
        assertEquals("song names should be the same", "Solovey 1", player.getSongName())
        player.goBack()
        assertEquals("song names should be the same", "Another Solovey", player.getSongName())
        player.releasePlayer()
    }

}