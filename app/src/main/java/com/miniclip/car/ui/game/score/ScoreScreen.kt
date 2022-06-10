package com.miniclip.car.ui.game.score

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.miniclip.car.R
import com.miniclip.car.ui.LeprechaunStoryNavKeys
import com.miniclip.car.ui.game.composables.TicTaeButton

@Composable
fun ScoreScreen(navController: NavController, winPlayer: Int) {
    val isSingleplayer by remember { mutableStateOf(winPlayer <= 0) }

    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.game_bg),
        contentDescription = null,
        contentScale = ContentScale.FillBounds
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            border = BorderStroke(2.dp, Color.White),
            shape = RoundedCornerShape(16.dp),
            backgroundColor = Color.Gray.copy(alpha = 0.9F),
        ) {
            Column(
                modifier = Modifier.padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = if (winPlayer != 10) {
                        if (isSingleplayer) {
                            if (winPlayer == 0) "You lose..." else "You won!"
                        } else {
                            "Player $winPlayer won!"
                        }
                    } else {
                        "Draw"
                    },
                    style = MaterialTheme.typography.h4.copy(color = Color.White)
                )
                Spacer(Modifier.height(32.dp))
                TicTaeButton(text = "Play again?") {
                    navController.navigate(LeprechaunStoryNavKeys.Game((winPlayer == 10 || isSingleplayer).toString()).route) {
                        popUpTo(LeprechaunStoryNavKeys.Score().route) { inclusive = true }
                    }
                }
                Spacer(Modifier.height(8.dp))
                TicTaeButton(text = "Menu") {
                    navController.navigate(LeprechaunStoryNavKeys.Menu.route) {
                        popUpTo(LeprechaunStoryNavKeys.Score().route) { inclusive = true }
                    }
                }
            }
        }
    }
}