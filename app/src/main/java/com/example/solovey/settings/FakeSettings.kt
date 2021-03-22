package com.example.solovey.settings

object FakeSettings: SettingsInterface {
    override fun incrementVolume() {}
    override fun decrementVolume() {}
    override fun getVolumeValue() = 0
}