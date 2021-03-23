package com.example.solovey

class MusicStorageTest() {
    val songs = listOf(R.raw.solovey, R.raw.solovey2)
    var index = -1
    fun next (): Int {
        if(index == songs.size - 1) {
            index = 0
        } else {
            index++
        }
        return songs[index]
    }

    fun prev (): Int {
        if(index == 0) {
            index = songs.size - 1
        } else {
            index--
        }
        return songs[index]
    }

    fun getName () : String {
        if(songs[index] == R.raw.solovey) return "Solovey 1"
        else return "Another Solovey"
    }
}