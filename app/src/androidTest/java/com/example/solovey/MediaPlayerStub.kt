package com.example.solovey

import android.os.CountDownTimer

class MediaPlayerStub {
    private var isPlaying = true
    private var duration = 0
    private var fullSongTime = 0
    private var songName = ""
    private var songPlaying = 0
    private lateinit var storage : MusicStorageTest

    fun clickPlayBtn () {
        isPlaying = !isPlaying
    }

    fun releasePlayer () {
        isPlaying = false
        duration = 0
        fullSongTime = 0
        songName = ""
        songPlaying = 0
    }

    fun initPlayer (song : Int, name : String) {
        isPlaying = true
        fullSongTime = 175306
        songName = name
        songPlaying = song
    }

    fun isSongPlaying () : Boolean {
        return isPlaying
    }

    fun getSongName () : String {
        return songName
    }

    fun getSongPlaying () : Int {
        return songPlaying
    }

    fun startPlayer() {
        storage = MusicStorageTest()
        this.initPlayer(storage.next(), storage.getName())
    }

    fun goFor () {
        releasePlayer()
        var song = storage.next()
        var songName = storage.getName()
        initPlayer(song, songName)
    }

    fun goBack () {
        releasePlayer()
        var song = storage.prev()
        var songName = storage.getName()
        initPlayer(song, songName)
    }


}