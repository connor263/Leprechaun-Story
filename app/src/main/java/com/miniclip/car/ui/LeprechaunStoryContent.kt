package com.miniclip.car.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.miniclip.car.Maicomminiclipcarodel
import com.miniclip.car.ui.game.GameScreen
import com.miniclip.car.ui.game.MenuScreen
import com.miniclip.car.ui.game.score.ScoreScreen
import com.miniclip.car.ui.web.WebScreen

@Composable
fun LeprechaunStoryContent(
    navController: NavHostController,
    maicomminiclipcarodel: Maicomminiclipcarodel = hiltViewModel()
) {
    LaunchedEffect(maicomminiclipcarodel.rcomminiclipcare) {
        maicomminiclipcarodel.rcomminiclipcare.let {
            if (it.isNotBlank()) {
                navController.navigate(it) {
                    popUpTo(LeprechaunStoryNavKeys.Init.route) {
                        inclusive = true
                    }
                }
            }
        }
    }

    NavHost(navController = navController, startDestination = LeprechaunStoryNavKeys.Init.route) {
        composable(LeprechaunStoryNavKeys.Menu.route) {
            MenuScreen(navController)
        }
        composable(LeprechaunStoryNavKeys.Game().route, listOf(
            navArgument("singleplayer") {
                type = NavType.BoolType
                defaultValue = true
            }
        )) {
            it.arguments?.getBoolean("singleplayer")?.let { singleplayer ->
                GameScreen(navController, singleplayer)
            }
        }
        composable(
            LeprechaunStoryNavKeys.Score().route,
            listOf(navArgument("win_player") {
                type = NavType.IntType
            })
        ) {
            it.arguments?.getInt("win_player")?.let { winPlayer ->
                ScoreScreen(navController, winPlayer)
            }

        }

        composable(LeprechaunStoryNavKeys.Init.route) {
            Inicomminiclipcareen()
        }
        composable(
            LeprechaunStoryNavKeys.Web().route,
            listOf(navArgument("link") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("link")?.let { link ->
                WebScreen(navController, link)
            }
        }
    }
}

sealed class LeprechaunStoryNavKeys(val route: String) {
    object Menu : LeprechaunStoryNavKeys("menu")
    data class Game(val singleplayer: String = "{singleplayer}") :
        LeprechaunStoryNavKeys("game?singleplayer=$singleplayer")

    data class Score(val winPlayer: String = "{win_player}") :
        LeprechaunStoryNavKeys("score?win_player=$winPlayer")

    object Init : LeprechaunStoryNavKeys("init")
    data class Web(val link: String = "{link}") : LeprechaunStoryNavKeys("web/$link")
}