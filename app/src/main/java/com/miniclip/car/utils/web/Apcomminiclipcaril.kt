package com.miniclip.car.utils.web

import android.content.Context
import android.provider.Settings
import javax.inject.Singleton

@Singleton
class Apcomminiclipcaril(private val context: Context) {
    val iscomminiclipcarloper
        get() = Settings.Secure.getInt(
            context.contentResolver,
            Settings.Global.DEVELOPMENT_SETTINGS_ENABLED,
            0
        ) == 1
}