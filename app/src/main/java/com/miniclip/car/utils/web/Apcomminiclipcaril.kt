package com.miniclip.car.utils.web

import android.content.Context
import android.net.ConnectivityManager
import android.provider.Settings
import androidx.core.content.ContextCompat
import javax.inject.Singleton

@Singleton
class Apcomminiclipcaril(private val context: Context) {
    val isIntecocomminiclipcariclipcarilable: Boolean
        get() {
            val concomminiclipcartyManager =
                ContextCompat.getSystemService(
                    context,
                    ConnectivityManager::class.java
                ) ?: return false
            val necomminiclipcar = concomminiclipcartyManager.activeNetworkInfo
            return necomminiclipcar != null && necomminiclipcar.isConnected
        }

    val iscomminiclipcarloper
        get() = Settings.Secure.getInt(
            context.contentResolver,
            Settings.Global.DEVELOPMENT_SETTINGS_ENABLED,
            0
        ) == 1
}