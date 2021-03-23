package com.example.solovey

class MusicTrack(val song: String, val group: String, val mp3: Int, iconID: Int?) {
    val iconID = iconID?: R.drawable.ic_launcher_background
}