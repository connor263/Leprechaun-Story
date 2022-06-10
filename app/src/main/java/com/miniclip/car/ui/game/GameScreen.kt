package com.miniclip.car.ui.game

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.miniclip.car.R
import com.miniclip.car.ui.LeprechaunStoryNavKeys
import com.miniclip.car.ui.game.composables.ChooseDrawablesBoard
import com.miniclip.car.ui.game.composables.TicTaeBackButton
import com.miniclip.car.ui.game.composables.TicTaeToeBoard
import kotlinx.coroutines.delay

@Composable
fun GameScreen(navController: NavController, singleplayer: Boolean) {
    val viewModel: GameViewModel = hiltViewModel()

    val context = LocalContext.current
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    val xStep = remember { screenWidth / 4 }
    val yStep = remember { screenHeight / 6 }

    LaunchedEffect(context) {
        viewModel.uiState.collect { state ->
            when (state) {
                is GameViewModel.GameEvent.GameOver -> {
                    delay(1000)

                    val playerNumber = if(state.draw == false) {
                        if (singleplayer) {
                            if (state.isAi == true) {
                                0
                            } else {
                                -1
                            }
                        } else {
                            state.winPlayer!!.turn.ordinal + 1
                        }
                    }else{
                        10
                    }
                    navController.navigate(
                        LeprechaunStoryNavKeys.Score(
                            playerNumber.toString()
                        ).route
                    ) {
                        popUpTo(
                            LeprechaunStoryNavKeys.Game().route
                        ) { inclusive = true }
                    }
                    viewModel.sendGameEndEvent(null, draw = true)
                }
                null -> {}
            }
        }
    }

    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.game_bg_4),
        contentDescription = null,
        contentScale = ContentScale.FillBounds
    )

    TicTaeBackButton(text = "Back") {
        navController.navigateUp()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.weight(0.25F),
            text = "Player turn: ${viewModel.playerTurn.ordinal + 1}",
            style = MaterialTheme.typography.h4.copy(
                color = Color.White,
                shadow = Shadow(Color.Black, blurRadius = 32F)
            ),
        )
        TicTaeToeBoard(modifier = Modifier.weight(1F, false), xStep, yStep)
    }

    ChooseDrawablesBoard(xStep, yStep, singleplayer)
}