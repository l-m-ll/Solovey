package com.example.solovey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var playlist = findViewById<Button>(R.id.playList)
        playlist.setOnClickListener {
            var intent = Intent(this, PlayListActivity::class.java)
            startActivity(intent)
        }

    }
}