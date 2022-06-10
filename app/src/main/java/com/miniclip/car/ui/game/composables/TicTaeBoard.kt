package com.miniclip.car.ui.game.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.miniclip.car.R
import com.miniclip.car.ui.game.GameViewModel


@Composable
fun TicTaeToeBoard(modifier: Modifier = Modifier, xStep: Int, yStep: Int) {
    val viewModel: GameViewModel = hiltViewModel()
    val boardCells = remember { viewModel.cellsList }

    Card(
        modifier = modifier.size(xStep.dp * 3, yStep.dp * 3),
        shape = RoundedCornerShape(24.dp),
        backgroundColor = Color.White.copy(alpha = 0.7F)
    ) {
        Column(
            modifier = Modifier.background(Color.Black),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            repeat(3) { index ->
                val list = boardCells.filter { it.row == index + 1 }
                Row {
                    list.forEach { cell ->
                        Card(
                            modifier = Modifier
                                .padding(1.dp)
                                .clickable {
                                    if (viewModel.player2.isAi && viewModel.playerTurn == viewModel.player2.turn) return@clickable
                                    viewModel.markCell(cell.position)
                                },
                            backgroundColor = if (cell.isWin) Color.Yellow.copy(alpha = 0.5F) else Color.White
                        ) {
                            Image(
                                modifier = Modifier.size(xStep.dp, yStep.dp),
                                painter = painterResource(
                                    id = if (cell.drawableRes == -1) {
                                        R.drawable.decal_1
                                    } else {
                                        cell.drawableRes
                                    }
                                ),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                alpha = if (cell.drawableRes == -1) 0F else 1F,
                            )
                        }
                    }
                }
            }
        }
    }
}