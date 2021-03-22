package com.example.solovey

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

open class SettingsActivity : AppCompatActivity() {
    private lateinit var sndDownButton: Button
    private lateinit var sndUpButton: Button
    private lateinit var volumeView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        volumeView = findViewById(R.id.volume_value)
        sndDownButton = findViewById(R.id.snd_down)
        sndUpButton = findViewById(R.id.snd_up)


        Settings.volumeView = volumeView
        Settings.volumeTextView = findViewById(R.id.volume_text)
        Settings.updateVolume()

        sndDownButton.setOnClickListener { Settings.decrementVolume() }
        sndUpButton.setOnClickListener { Settings.incrementVolume() }
    }
}
