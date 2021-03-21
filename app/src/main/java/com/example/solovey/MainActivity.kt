package com.example.solovey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val player = findViewById<Button>(R.id.player)
        player.setOnClickListener {
            val intent = Intent(this, activity_play::class.java)
            startActivity(intent)
        }
    }
}