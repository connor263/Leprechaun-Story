package com.miniclip.car.data.model.web

import android.content.Context
import com.facebook.FacebookSdk
import com.facebook.applinks.AppLinkData
import com.miniclip.car.R
import com.miniclip.car.interfaces.CachcomminiclipcarResulerAfPecomminepository
import com.miniclip.car.interfaces.PastcomminiclipcarResulerAfPecomminsitory
import com.miniclip.car.utils.web.Apcomminiclipcaril
import com.miniclip.car.utils.web.Apcomminiclipcars
import com.miniclip.car.utils.web.WecomminiclipcarResult
import com.miniclip.car.utils.web.comminiclipcar
import com.miniclip.car.utils.web.enums.WebLincomminiclipcarcomminiclipcars
import com.miniclip.car.utils.web.enums.WebLinkcomminiclipcarMessage
import com.onesignal.OneSignal
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first

data class WebecomlecomminiclipcarResulnk(val link: String?) {
    private constructor(buiecomminiclipcarResulr: BuiecomminiclipcarResulr) : this(
        buiecomminiclipcarResulr.collcomminiclipcarResulerAfPecomminaLink
    )

    class BuiecomminiclipcarResulr(
        private val context: Context,
        private val cachcomminiclipcarResulerAfPecomminepositoryImpl: CachcomminiclipcarResulerAfPecomminepository,
        private val pastcomminiclipcarResulerAfPecomminsitoryImpl: PastcomminiclipcarResulerAfPecomminsitory
    ) {
        val fetchecomminiclipcarResulFlow = MutableStateFlow(false)

        var collcomminiclipcarResulerAfPecomminaLink: String? = null
            private set

        private var wGocomminiclipcarResulerAfPecomminaeId: String? = null
        private var wAfcomminiclipcarResulerAfPecomminaserId: String? = null
        private var wSucomminicerAfPecomminaAll: List<String> =
            listOf("", "", "", "", "", "", "", "", "", "")
        private var wDecomminicerAfPecomminapLink: String? = null
        private var wMecomminicerAfPecomminaiaSource: String? = null
        private var wAfcomminicerAfPecomminahannel: String? = null
        private var wCacomminiclipcarResulerAfPecomminapaign: String? = null
        private var wUrcomminiclipcarResulerAfPecommina: String? = null
        private var wSwcomminiclipcarResulerAfPecomminatch: Boolean? = null

        suspend fun incomminiclipcarResulerAfPecomminat(): WecomminiclipcarResult<String?>? {
            val lcomminiclipcarResulerAfPecommina =
                cachcomminiclipcarResulerAfPecomminepositoryImpl.getcomminiclipcarResulerAfPecomminLink()
                    .first()?.link ?: ""
            return if (lcomminiclipcarResulerAfPecommina.isNotBlank()) {
                WecomminiclipcarResult.Scomminiclipcars(
                    data = lcomminiclipcarResulerAfPecommina,
                    linkStatus = WebLincomminiclipcarcomminiclipcars.CACHE
                )
            } else {
                fecomminiclipcarResulerAfPecomminaata()
                null
            }

        }

        private suspend fun fecomminiclipcarResulerAfPecomminaata() {
            pastcomminiclipcarResulerAfPecomminsitoryImpl.fetchcomminiclipcarResulerAfPecomminSwitch { url, switch ->
                this.wUrcomminiclipcarResulerAfPecommina = url
                this.wSwcomminiclipcarResulerAfPecomminatch = switch
                fetchecomminiclipcarResulFlow.emit(url.contains("jhfb".comminiclipcar()))
            }
        }

        fun becomminiclipcarResuln() {
            scarResulerAfPecomminDS()
            setcarResulerAfPecomminpLink()
        }


        private fun scarResulerAfPecomminDS() {
            Apcomminiclipcars(context).let {
                this.wAfcomminiclipcarResulerAfPecomminaserId = it.appcomminiclipcarId
                this.wGocomminiclipcarResulerAfPecomminaeId = it.gcomminiclipcareId
                OneSignal.setExternalUserId(this.wGocomminiclipcarResulerAfPecomminaeId.toString())
            }
        }

        private fun setcarResulerAfPecomminpLink() {
            FacebookSdk.setAutoInitEnabled(true)
            FacebookSdk.fullyInitialize()
            AppLinkData.fetchDeferredAppLinkData(context) {
                it?.targetUri?.toString()?.let { deepLink ->
                    this.wDecomminicerAfPecomminapLink = deepLink
                    this.wSucomminicerAfPecomminaAll = deepLink.split("//")[1].split("_")
                }
            }
        }

        private fun checkMediaarResulerAfPecommorOrganic() =
            this.wMecomminicerAfPecomminaiaSource == "qfsmvvk".comminiclipcar()

        private fun isOrgaarResulerAfPecommessClose() =
            checkMediaarResulerAfPecommorOrganic() && wSwcomminiclipcarResulerAfPecomminatch == false

        fun buarResulerAfPecommd(): WebecomlecomminiclipcarResulnk {
            val wRarResulerAfPecommrces = context.resources
            val wParResulerAfPecommgeName = context.packageName
            val wAppsarResulerAfPecommrDevKey =
                wRarResulerAfPecommrces.getString(R.string.apps_dev_key)
            val wFarResulerAfPecommen = wRarResulerAfPecommrces.getString(R.string.fb_at)
            val wFbarResulerAfPecommd = wRarResulerAfPecommrces.getString(R.string.fb_app_id)

            var wIarResulerAfPecommex = 0
            val wSubsString = this.wSucomminicerAfPecomminaAll.joinToString(separator = "") {
                wIarResulerAfPecommex++
                "&sub$wIarResulerAfPecommex=$it"
            }

            val wStrarResulerAfPecommaSource = "?ospui_fwwckt=".comminiclipcar()
            val warResulerAfPecommogleId = "&icastr_iftl=".comminiclipcar()
            val warResulerAfPecommFlyerUserId = "&ct_gemeqf=".comminiclipcar()
            val wStrarResulerAfPecommeName = "&dizptr=".comminiclipcar()
            val wStrarResulerAfPecommerDevKey = "&fsh_wml=".comminiclipcar()
            val wSarResulerAfPecommToken = "&hp_mf=".comminiclipcar()
            val wSarResulerAfPecommppId = "&hp_mbx_vl=".comminiclipcar()
            val wSarResulerAfPecommhannel = "&ct_otiavgw=".comminiclipcar()
            val wStrarResulerAfPecommpaign = "&eoybivop=".comminiclipcar()


            if (Apcomminiclipcaril(context).iscomminiclipcarloper && checkMediaarResulerAfPecommorOrganic() ||
                isOrgaarResulerAfPecommessClose()
            ) {
                throw Exception(WebLinkcomminiclipcarMessage.ORGANIC_OR_DEVELOPER.name)
            }

            collcomminiclipcarResulerAfPecomminaLink =
                "${this.wUrcomminiclipcarResulerAfPecommina}" +
                        "$wStrarResulerAfPecommaSource${this.wMecomminicerAfPecomminaiaSource}" +
                        "$warResulerAfPecommogleId${this.wGocomminiclipcarResulerAfPecomminaeId}" +
                        "$warResulerAfPecommFlyerUserId${this.wAfcomminiclipcarResulerAfPecomminaserId}" +
                        "$wStrarResulerAfPecommeName$wParResulerAfPecommgeName" +
                        "$wStrarResulerAfPecommerDevKey$wAppsarResulerAfPecommrDevKey" +
                        "$wSarResulerAfPecommToken$wFarResulerAfPecommen" +
                        "$wSarResulerAfPecommppId$wFbarResulerAfPecommd" +
                        "$wSarResulerAfPecommhannel${this.wAfcomminicerAfPecomminahannel}" +
                        "$wStrarResulerAfPecommpaign${this.wCacomminiclipcarResulerAfPecomminapaign}" +
                        wSubsString

            return WebecomlecomminiclipcarResulnk(this)
        }

        inner class AfPecomminiclipcarResuls {
            fun setecomminiclipcarResuls(value: String) = with(this@BuiecomminiclipcarResulr) {
                val organicWithO = "qfsmvvk".comminiclipcar().replaceFirstChar { it.uppercase() }
                if (value == organicWithO && this.wDecomminicerAfPecomminapLink == null) {
                    wMecomminicerAfPecomminaiaSource = "qfsmvvk".comminiclipcar()
                }
            }

            fun setecomminiclipcarResulampaign(value: String) =
                with(this@BuiecomminiclipcarResulr) {
                    wCacomminiclipcarResulerAfPecomminapaign = value
                    wSucomminicerAfPecomminaAll = value.split("_")
                }

            fun setecomminiclipcarResulnel(value: String) = with(this@BuiecomminiclipcarResulr) {
                wAfcomminicerAfPecomminahannel = value
            }

            fun setAfecomminiclipcarResulSource(value: String) =
                with(this@BuiecomminiclipcarResulr) {
                    wMecomminicerAfPecomminaiaSource = value
                }
        }
    }
}