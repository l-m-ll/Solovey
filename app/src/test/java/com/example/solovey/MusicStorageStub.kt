package com.example.solovey

class MusicStorageStub: MusicStorage() {
    override fun saveSong(song: MusicTrack, name: String): Boolean {
        return true
    }
}
