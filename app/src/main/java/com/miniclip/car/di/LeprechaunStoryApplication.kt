package com.miniclip.car.di

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.miniclip.car.R
import com.miniclip.car.TAG
import com.onesignal.OneSignal
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class LeprechaunStoryApplication : Application() {
    @Inject
    lateinit var afLcomminiclipcarResulerAfPecommina: MutableLiveData<MutableMap<String, Any>>

    override fun onCreate() {
        super.onCreate()
       initadfasdvavma()
    }

    private fun initadfasdvavma() {
        avdakalfdawldmaslmvml()
    }

    private fun avdakalfdawldmaslmvml() {
        AppsFlyerLib.getInstance()
            .init(getString(R.string.apps_dev_key), object : AppsFlyerConversionListener {
                override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
                    data?.let {
                        afLcomminiclipcarResulerAfPecommina.postValue(it)
                        Log.d(TAG, "onConversionDataSuccess: $it")
                    }
                }

                override fun onConversionDataFail(p0: String?) {}
                override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {}
                override fun onAttributionFailure(p0: String?) {}
            }, this)
        AppsFlyerLib.getInstance().start(this)
        dakamlalwdgoadoag()
    }

    private fun dakamlalwdgoadoag() {
        gmsmgrgpoegowgm()
    }

    private fun gmsmgrgpoegowgm() {
        OneSignal.initWithContext(this)
        OneSignal.setAppId(getString(R.string.one_signal_key))
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
    }
}