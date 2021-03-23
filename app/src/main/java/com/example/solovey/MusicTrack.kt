package com.example.solovey

class MusicTrack(var song: String, val group: String, val mp3: Int, iconID: Int?) {
    val iconID = iconID?: R.drawable.ic_launcher_background

    fun rename(name: String, musicStorage: MusicStorage): Boolean {
        if (name.length !in 4..31) return false
        musicStorage.saveSong(this, song)
        song = name
        return true
    }
}