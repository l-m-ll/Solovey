package com.example.solovey

import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.runners.MockitoJUnitRunner

private const val FAKE_SONG_STRING = "some song"
private const val FAKE_GROUP_STRING = "some group"
private const val FAKE_MP3ID_INT = 1
private const val FAKE_ICONID_INT = 2
private const val DEFAULT_ICONID_INT = R.drawable.ic_launcher_background

@RunWith(MockitoJUnitRunner::class)
class MusicTrackTest {

    lateinit var musicTrack: MusicTrack

    @Mock private lateinit var musicStorage: MusicStorage

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

    @After
    fun after() {
        musicTrack = MusicTrack(FAKE_SONG_STRING, FAKE_GROUP_STRING, FAKE_MP3ID_INT, FAKE_ICONID_INT)
    }

    @Test fun `rename song test with correct args`() {
        musicTrack = MusicTrack(FAKE_SONG_STRING, FAKE_GROUP_STRING, FAKE_MP3ID_INT, null)
        musicTrack.rename(FAKE_GROUP_STRING, musicStorage)
        verify(musicStorage, times(1)).saveSong(musicTrack, FAKE_SONG_STRING)
    }

    @Test fun `test return rename song test with correct args and stub`() {
        musicTrack = MusicTrack(FAKE_SONG_STRING, FAKE_GROUP_STRING, FAKE_MP3ID_INT, null)
        var musicStorageStub: MusicStorageStub = MusicStorageStub()
        assertEquals(musicTrack.rename(FAKE_GROUP_STRING, musicStorageStub), true)
    }

}