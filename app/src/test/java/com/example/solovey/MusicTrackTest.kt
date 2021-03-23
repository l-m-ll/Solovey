package com.example.solovey

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mock

private const val FAKE_SONG_STRING = "some song"
private const val FAKE_GROUP_STRING = "some group"
private const val FAKE_MP3ID_INT = 1
private const val FAKE_ICONID_INT = 2
private const val DEFAULT_ICONID_INT = R.drawable.ic_launcher_background

class MusicTrackTest {

    @Mock lateinit var viewGroup: ViewGroup
    @Mock lateinit var view: View
    @Mock lateinit var context: Context

    lateinit var musicTrack: MusicTrack


    @Test fun `test args define with correct args`() {
        musicTrack = MusicTrack(FAKE_SONG_STRING, FAKE_GROUP_STRING, FAKE_MP3ID_INT, FAKE_ICONID_INT)
        assertEquals(musicTrack.song, FAKE_SONG_STRING)
        assertEquals(musicTrack.group, FAKE_GROUP_STRING)
        assertEquals(musicTrack.mp3, FAKE_MP3ID_INT)
        assertEquals(musicTrack.iconID, FAKE_ICONID_INT)
    }

    @Test fun `test args define with null iconID`() {
        musicTrack = MusicTrack(FAKE_SONG_STRING, FAKE_GROUP_STRING, FAKE_MP3ID_INT, null)
        assertEquals(musicTrack.song, FAKE_SONG_STRING)
        assertEquals(musicTrack.group, FAKE_GROUP_STRING)
        assertEquals(musicTrack.mp3, FAKE_MP3ID_INT)
        assertEquals(musicTrack.iconID, DEFAULT_ICONID_INT)
    }

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
        assertEquals(adapter::class, PlayListAdapter::class)
    }
}