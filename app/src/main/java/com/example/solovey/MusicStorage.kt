package com.example.solovey

open class MusicStorage {
    private val mStorage: Map<String, Int> = HashMap()
    private val mIdStorage: Map<Int, MusicTrack> = HashMap()

    open fun saveSong(song: MusicTrack, name: String): Boolean {
        val randomId = 3
        //mIdStorage.put (randomId, song)
        return true
    }
}