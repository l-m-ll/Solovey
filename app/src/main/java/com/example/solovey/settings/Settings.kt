package com.example.solovey.settings

import android.annotation.SuppressLint
import android.widget.TextView

@SuppressLint("StaticFieldLeak")
object Settings: SettingsInterface {
    lateinit var volumeView: TextView
    var volume = 20
    override fun incrementVolume() {
        volume++
        updateVolume()
    }
    override fun decrementVolume() {
        volume--
        updateVolume()
    }
    override fun getVolumeValue() = volume
    fun updateVolume() {
        volumeView.text = volume.toString()
    }
}