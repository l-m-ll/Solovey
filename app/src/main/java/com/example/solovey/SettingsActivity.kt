package com.example.solovey

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        (findViewById<Button>(R.id.snd_down)).setOnClickListener { Settings.volume-- }
        (findViewById<Button>(R.id.snd_up)).setOnClickListener { Settings.volume++ }
    }
}