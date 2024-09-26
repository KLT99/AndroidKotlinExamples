package com.klt.androidkotlinexamples.settings

data class SettingsModel(
    var volume: Int,
    var bluetooth: Boolean,
    var darkMode: Boolean,
    var vibrator: Boolean
)
