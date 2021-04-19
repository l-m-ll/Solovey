package com.example.solovey

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_play.*

class activity_play : AppCompatActivity() {
    private lateinit var mp3: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        initPlayer(R.raw.solovey)
    }

    fun initPlayer (song: Int) {
        mp3 = MediaPlayer.create(this, song)
        timeBar.max = (mp3.duration / 1000).toInt()
        timeBar.progress = 0
        mp3.isLooping = true
        mp3.setVolume(0.5f, 0.5f)
        mp3.start()

        timeBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mp3.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                switchOnTimeBar(seekBar)
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                switchOnTimeBar(seekBar)
            }
        })

        Thread(Runnable {
            while(mp3 != null) {
                try {
                    var msg = Message()
                    msg.what = mp3.currentPosition
                    handler.sendMessage(msg)
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {

                }
            }
        }).start()
    }

    fun getMp3() : MediaPlayer {
        return mp3
    }

    fun switchOnTimeBar(seekBar : SeekBar) {
        mp3.seekTo(seekBar.progress * 1000)
        timeBar.progress = seekBar.progress
    }

    @SuppressLint("HandlerLint")
    var handler = object: Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            var currentPosition = msg.what
            timeBar.progress = (currentPosition / 1000).toInt()
        }
    }

    fun clickPlayBtn(v : View) : String {
        if (mp3.isPlaying) {
            mp3.pause()
            pause.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24)
            return "pause"
        } else {
            mp3.start()
            pause.setBackgroundResource(R.drawable.ic_baseline_pause_24)
            return "start"
        }
    }

    fun clickGoForBtn(v : View) {

    }

    fun clickGoBackBtn(v : View) {

    }
}