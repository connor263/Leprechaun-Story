package com.miniclip.car.ui.game.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.miniclip.car.ui.game.GameViewModel
import com.miniclip.car.utils.enums.PlayerTurn
import com.miniclip.car.utils.listOfDecals

@Composable
fun ChooseDrawablesBoard(xStep: Int, yStep: Int, singleplayer: Boolean) {
    val viewModel: GameViewModel = hiltViewModel()

    val player1 = remember { viewModel.player1 }
    val player2 = remember {
        viewModel.player2.apply {
            if (singleplayer) {
                isAi = true
                chosenDrawable = listOfDecals.random()
            }
        }
    }
    var expandChooseDrawable by remember { mutableStateOf(true) }
    AnimatedVisibility(expandChooseDrawable) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5F)),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier.padding(horizontal = 8.dp),
                backgroundColor = Color.Yellow,
                shape = RoundedCornerShape(16.dp)
            ) {

                Column(
                    modifier = Modifier.padding(18.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(horizontalArrangement = Arrangement.Center) {
                        PlayerChoosingDrawable(
                            modifier = Modifier.weight(0.5F),
                            xStep = xStep,
                            yStep = yStep,
                            player = player1
                        )
                        if (!singleplayer) {
                            Spacer(modifier = Modifier.width(8.dp))
                            PlayerChoosingDrawable(
                                modifier = Modifier.weight(0.5F),
                                xStep = xStep,
                                yStep = yStep,
                                player = player2
                            )
                        }
                    }
                    Spacer(Modifier.height(16.dp))
                    TicTaeButton(text = "Done") {
                        viewModel.checkPlayersDrawable(singleplayer)
                        expandChooseDrawable = false
                    }
                }
            }
        }
    }
}