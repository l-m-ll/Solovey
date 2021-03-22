package com.example.solovey.settings

interface SettingsInterface {
    fun incrementVolume()
    fun decrementVolume()
    fun getVolumeValue(): Int
}