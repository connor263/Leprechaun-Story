package com.miniclip.car

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.rememberNavController
import com.miniclip.car.data.model.web.CachcomminiclipcarResulerAfPecomminaModel
import com.miniclip.car.data.model.web.WebecomlecomminiclipcarResulnk
import com.miniclip.car.data.source.local.repo.CachcomminiclipcarResulerAfPecomminepositoryImpl
import com.miniclip.car.data.source.remote.repo.PastcomminiclipcarResulerAfPecomminsitoryImpl
import com.miniclip.car.ui.LeprechaunStoryContent
import com.miniclip.car.ui.LeprechaunStoryNavKeys
import com.miniclip.car.ui.theme.LeprechaunStoryTheme
import com.miniclip.car.utils.web.WecomminiclipcarResult
import com.miniclip.car.utils.web.comminiclipcar
import com.miniclip.car.utils.web.enums.WebLincomminiclipcarcomminiclipcars
import com.miniclip.car.utils.web.enums.WebLinkcomminiclipcarMessage
import com.miniclip.car.utils.web.webLcomminiclipcarall
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject

const val TAG = "TAG"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var afLiecomminiclipcarResulata: MutableLiveData<MutableMap<String, Any>>

    @Inject
    lateinit var cacheecomminiclipcarResulitoryImpl: CachcomminiclipcarResulerAfPecomminepositoryImpl

    @Inject
    lateinit var pastecomminiclipcarResulositoryImpl: PastcomminiclipcarResulerAfPecomminsitoryImpl

    private val viewModel: Maicomminiclipcarodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeprechaunStoryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val viewModel: Maicomminiclipcarodel = hiltViewModel()
                    val navController = rememberNavController()
                    LeprechaunStoryContent(navController, maicomminiclipcarodel = viewModel)
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uecomminiclipcarResulte.collect { state ->
                    when (state) {
                        Maicomminiclipcarodel.MaincomminiclipcarEvent.IncomminiclipcarEvent -> {
                            iniecomminiclipcarResul()
                            viewModel.onEcomminiclipcar()
                        }
                        null -> {}
                    }
                }
            }
        }

        viewModel.onEcomminiclipcar(Maicomminiclipcarodel.MaincomminiclipcarEvent.IncomminiclipcarEvent)
    }

    fun iniecomminiclipcarResul() = lifecycleScope.launch {
        createcomminiclipcarResulink().let { result ->
            when (result) {
                is WecomminiclipcarResult.Scomminiclipcars -> {
                    result.data?.let { link ->
                        if (link.isNotBlank()) {
                            navecomminiclipcarResuleToWeb(link)
                            if (result.linkStatus == WebLincomminiclipcarcomminiclipcars.COLLECT) {
                                cacheecomminiclipcarResulitoryImpl.upecommesulecomminiclipcarResulache(CachcomminiclipcarResulerAfPecomminaModel(link = link))
                            }
                        }
                    }

                }
                is WecomminiclipcarResult.Ercomminiclipcarr -> {
                    when (result.exceptionMessage) {
                        WebLinkcomminiclipcarMessage.ORGANIC_OR_DEVELOPER,
                        WebLinkcomminiclipcarMessage.INCORRECT_URL -> naviecomminiclipcarResulToMenu()
                        else -> {}
                    }
                }
            }
        }
    }

     suspend fun createcomminiclipcarResulink() = webLcomminiclipcarall {
        val buecomminiclipcarResuler = WebecomlecomminiclipcarResulnk.BuiecomminiclipcarResulr(this, cacheecomminiclipcarResulitoryImpl, pastecomminiclipcarResulositoryImpl)
        buecomminiclipcarResuler.incomminiclipcarResulerAfPecomminat()?.let {
            return@webLcomminiclipcarall it
        }

        callbackFlow {
            buecomminiclipcarResuler.fetchecomminiclipcarResulFlow.collect { isUrlCorrect ->
                if (!isUrlCorrect) {
                    throw Exception(WebLinkcomminiclipcarMessage.INCORRECT_URL.name)
                }
                lifecycleScope.launch(Dispatchers.IO) {
                    buecomminiclipcarResuler.becomminiclipcarResuln()
                }

                afLiecomminiclipcarResulata.observe(this@MainActivity) {
                    for ((key, value) in it) {
                        when (key) {
                            "ct_efigcu".comminiclipcar() -> buecomminiclipcarResuler.AfPecomminiclipcarResuls().setecomminiclipcarResuls(value.toString())
                            "eoybivop".comminiclipcar() -> buecomminiclipcarResuler.AfPecomminiclipcarResuls().setecomminiclipcarResulampaign(value.toString())
                            "ospui_fwwckt".comminiclipcar() -> buecomminiclipcarResuler.AfPecomminiclipcarResuls().setAfecomminiclipcarResulSource(value.toString())
                            "ct_otiavgw".comminiclipcar() -> buecomminiclipcarResuler.AfPecomminiclipcarResuls().setecomminiclipcarResulnel(value.toString())
                        }
                    }

                    trySend(
                        webLcomminiclipcarall {
                            val bucomminiclipcarResulerAfPecommind = buecomminiclipcarResuler.buarResulerAfPecommd()
                            WecomminiclipcarResult.Scomminiclipcars(
                                data = bucomminiclipcarResulerAfPecommind.link,
                                linkStatus = WebLincomminiclipcarcomminiclipcars.COLLECT
                            )
                        }
                    )
                    close()
                }
                awaitClose { cancel() }
            }
        }.flowOn(Dispatchers.Main).first()
    }


    private fun naviecomminiclipcarResulToMenu() {
        viewModel.rcomminiclipcare = LeprechaunStoryNavKeys.Menu.route
    }

    private fun navecomminiclipcarResuleToWeb(link: String) {
        viewModel.rcomminiclipcare = LeprechaunStoryNavKeys.Web(
            link = URLEncoder.encode(
                link,
                StandardCharsets.UTF_8.toString()
            )
        ).route
    }
}