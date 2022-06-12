package com.miniclip.car.utils.web

import android.content.Context
import com.appsflyer.AppsFlyerLib
import com.google.android.gms.ads.identifier.AdvertisingIdClient

class Apcomminiclipcars(private val context: Context) {
    val appcomminiclipcarId: String
        get() = AppsFlyerLib.getInstance().getAppsFlyerUID(context).toString()

    val gcomminiclipcareId: String
        get() = AdvertisingIdClient.getAdvertisingIdInfo(context).id.toString()
}