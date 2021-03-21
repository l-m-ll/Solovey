package com.example.solovey

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_play.*

class activity_play : AppCompatActivity() {
    private lateinit var mp3: MediaPlayer
    private var timePassed: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        mp3 = MediaPlayer.create(this, R.raw.solovey)
        mp3.start()
        mp3.isLooping = true
        mp3.setVolume(0.5f, 0.5f)
        timePassed = mp3.duration
    }

    fun clickPlayBtn(v : View) {
        if (mp3.isPlaying) {
            mp3.pause()
            pause.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24)
        } else {
            mp3.start()
            pause.setBackgroundResource(R.drawable.ic_baseline_pause_24)
        }
    }
}