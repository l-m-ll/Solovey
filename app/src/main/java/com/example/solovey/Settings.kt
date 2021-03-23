package com.example.solovey

import android.annotation.SuppressLint
import android.widget.TextView

@SuppressLint("StaticFieldLeak")
object Settings {
    lateinit var volumeView: TextView
    lateinit var volumeTextView: TextView
    private var userName = "default"
    var volume = 20

    fun incrementVolume() {
        volume++
        updateVolume()
    }

    fun decrementVolume() {
        volume--
        updateVolume()
    }

    fun updateVolume() {
        volumeView.text = volume.toString()
    }

    fun setTextColor(colorId: Int) {
        volumeView.setBackgroundColor(colorId)
        volumeTextView.setBackgroundColor(colorId)
    }

    fun setUserName(name: String): Boolean {
        val forbiddenSymbols = listOf('.', ',', ':', ';')
        return if (!forbiddenSymbols.any { it in name }) {
            userName = name
            true
        } else false
    }
    fun getUserName() = userName
}