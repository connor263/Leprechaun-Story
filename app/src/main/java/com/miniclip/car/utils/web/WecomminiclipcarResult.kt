package com.miniclip.car.utils.web

import com.miniclip.car.utils.web.enums.WebLincomminiclipcarcomminiclipcars
import com.miniclip.car.utils.web.enums.WebLinkcomminiclipcarMessage

sealed class WecomminiclipcarResult<T>(
    val data: T? = null,
    val linkStatus: WebLincomminiclipcarcomminiclipcars? = null,
    val exceptionMessage: WebLinkcomminiclipcarMessage? = null
) {
    class Scomminiclipcars<T>(data: T? = null, linkStatus: WebLincomminiclipcarcomminiclipcars) :
        WecomminiclipcarResult<T>(data = data, linkStatus = linkStatus)

    class Ercomminiclipcarr<T>(data: T? = null, exceptionMessage: WebLinkcomminiclipcarMessage) :
        WecomminiclipcarResult<T>(data = data, exceptionMessage = exceptionMessage)
}
