package com.example.solovey

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PlayerBtnsTest {
    @After
    fun after() {
        Espresso.pressBackUnconditionally()
    }

    @Test
    fun checkBtnsExistance() {
        ActivityScenario.launch(activity_play::class.java);
        onView(withId(R.id.pause)).check(matches(isDisplayed()))
        onView(withId(R.id.gofor)).check(matches(isDisplayed()))
        onView(withId(R.id.goback)).check(matches(isDisplayed()))
        onView(withId(R.id.timeBar)).check(matches(isDisplayed()))
    }

    @Test
    fun getFirstSong () {
        ActivityScenario.launch(activity_play::class.java);
        var storage = MusicStorageTest()
        var song = storage.next()
        var songName = storage.getName()
        assertEquals("songs name should be the same", songName, "Solovey 1")
    }

    @Test
    fun initPlayer() {
        ActivityScenario.launch(activity_play::class.java);
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
        ActivityScenario.launch(activity_play::class.java);
        var player = MediaPlayerStub();
        player.startPlayer()
        player.releasePlayer()
        assertEquals( "player should not be playing", false, player.isSongPlaying())
    }

    @Test
    fun clickPauseBtn() {
        ActivityScenario.launch(activity_play::class.java);
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
        ActivityScenario.launch(activity_play::class.java);
        var player = MediaPlayerStub();
        player.startPlayer()
        assertEquals("song names should be the same", "Solovey 1", player.getSongName())
        player.goFor()
        assertEquals("song names should be the same", "Another Solovey", player.getSongName())
        player.releasePlayer()
    }

    @Test
    fun clickGoBackBtn() {
        ActivityScenario.launch(activity_play::class.java);
        var player = MediaPlayerStub();
        player.startPlayer()
        assertEquals("song names should be the same", "Solovey 1", player.getSongName())
        player.goBack()
        assertEquals("song names should be the same", "Another Solovey", player.getSongName())
        player.releasePlayer()
    }

}