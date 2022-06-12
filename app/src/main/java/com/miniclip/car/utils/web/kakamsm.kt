package com.miniclip.car.utils.web

import com.miniclip.car.utils.web.enums.WebLinkcomminiclipcarMessage

fun String.comminiclipcar(encrypt: Boolean = false): String {
    val comminiclipcar = StringBuilder()
    val adsgccomminiclipcariclipcarbas = "comminiclipcar"
    var ddfbscocomminiclipcarclipcarqlbl = 0

    this.forEach {
        if (it !in 'a'..'z') {
            comminiclipcar.append(it)
            return@forEach
        }
        val wlfgflga = if (encrypt) {
            (it.code + adsgccomminiclipcariclipcarbas[ddfbscocomminiclipcarclipcarqlbl].code - 90) % 26
        } else {
            (it.code - adsgccomminiclipcariclipcarbas[ddfbscocomminiclipcarclipcarqlbl].code + 26) % 26
        }
        ddfbscocomminiclipcarclipcarqlbl++
        if (ddfbscocomminiclipcarclipcarqlbl > adsgccomminiclipcariclipcarbas.length - 1) ddfbscocomminiclipcarclipcarqlbl = 0
        comminiclipcar.append(wlfgflga.plus(97).toChar())
    }
    return comminiclipcar.toString()
}


inline fun <T> webLcomminiclipcarall(action: () -> WecomminiclipcarResult<T?>): WecomminiclipcarResult<T?>{
    return try {
        action()
    } catch (e: Exception) {
        WecomminiclipcarResult.Ercomminiclipcarr(
            exceptionMessage = WebLinkcomminiclipcarMessage.valueOf(
                e.message ?: "empty"
            )
        )
    }
}