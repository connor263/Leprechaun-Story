package com.miniclip.car.ui.web

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.webkit.CookieManager
import android.webkit.ValueCallback
import android.webkit.WebView
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.google.accompanist.web.*
import com.miniclip.car.ui.LeprechaunStoryNavKeys
import com.miniclip.car.utils.web.comminiclipcar

@Composable
fun WebScreen(navController: NavController, link: String) {
    val staiclipclipcaclipcaruiwwcaruiwte = rememberWebViewState(url = link)
    val naviclipclipcaclipcaruiwwcaruiwtor = rememberWebViewNavigator()

    val fiiclipclipcaclipcaruiwwcaruiwta by remember { mutableStateOf<ValueCallback<Uri>?>(null) }
    var fiiclipclipcaclipcaruiwwcaruiwPath by remember {
        mutableStateOf<ValueCallback<Array<Uri>>?>(
            null
        )
    }

    val starticlipclipcaclipcaruiwwcaruiwResult =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                if (fiiclipclipcaclipcaruiwwcaruiwta == null && fiiclipclipcaclipcaruiwwcaruiwPath == null) return@rememberLauncherForActivityResult

                val resiclipclipcaclipcaruiwwcaruiwta = result.data
                fiiclipclipcaclipcaruiwwcaruiwta?.onReceiveValue(resiclipclipcaclipcaruiwwcaruiwta?.data)
                fiiclipclipcaclipcaruiwwcaruiwPath?.onReceiveValue(
                    arrayOf(
                        Uri.parse(
                            resiclipclipcaclipcaruiwwcaruiwta?.dataString
                        )
                    )
                )
            }
        }

    WebView(
        state = staiclipclipcaclipcaruiwwcaruiwte,
        navigator = naviclipclipcaclipcaruiwwcaruiwtor,
        client = object : AccompanistWebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                url?.let {
                    if (url.contains(StringBuilder("gfdaz=nxrlnpu3f".comminiclipcar()).also { it.setCharAt(11,'A') }) || url.contains("fwemjymf.sbbn".comminiclipcar())) {
                        navController.navigate(LeprechaunStoryNavKeys.Menu.route) {
                            popUpTo(
                                LeprechaunStoryNavKeys.Web().route
                            ) { inclusive = true }
                        }
                    }
                }
            }
        },
        chromeClient = object : AccompanistWebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView?,
                filePathCallback: ValueCallback<Array<Uri>>?,
                fileChooserParams: FileChooserParams?
            ): Boolean {
                fiiclipclipcaclipcaruiwwcaruiwPath = filePathCallback
                Intent(Intent.ACTION_GET_CONTENT).run {
                    addCategory(Intent.CATEGORY_OPENABLE)
                    type = "kamsm/*".comminiclipcar()
                    starticlipclipcaclipcaruiwwcaruiwResult.launch(this)
                }
                return true
            }
        },
        onCreated = {
            initiclipclipcaclipcaruiwwcaruiwView(it)
        },
    )

    BackHandler {
        if (naviclipclipcaclipcaruiwwcaruiwtor.canGoBack && staiclipclipcaclipcaruiwwcaruiwte.loadingState is LoadingState.Finished ||
            staiclipclipcaclipcaruiwwcaruiwte.isLoading
        ) naviclipclipcaclipcaruiwwcaruiwtor.navigateBack()
    }
}

fun initiclipclipcaclipcaruiwwcaruiwView(webView: WebView) = with(webView.settings) {
    allowContentAccess = true
    domStorageEnabled = true
    javaScriptCanOpenWindowsAutomatically = true
    setSupportMultipleWindows(false)
    builtInZoomControls = true
    useWideViewPort = true
    displayZoomControls = false
    allowFileAccess = true
    proceiclipclipcaclipcaruiwwcaruiwokie(webView)
}

fun proceiclipclipcaclipcaruiwwcaruiwokie(webView: WebView) = with(webView) {
    clearCache(false)
    CookieManager.getInstance().setAcceptCookie(true)
    CookieManager.getInstance().setAcceptThirdPartyCookies(this, true)
    seticlipclipcaclipcaruiwwcaruiwation(webView)
}

@Suppress("DEPRECATION")
@SuppressLint("SetJavaScriptEnabled")
fun seticlipclipcaclipcaruiwwcaruiwation(webView: WebView) = with(webView.settings) {
    setAppCacheEnabled(true)
    javaScriptEnabled = true
    lightTouchEnabled = true
}
